/**/
package com.jcg.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.jcg.model.Login;
import com.jcg.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public User validateUser(Login login) {
	  login.setPassword("manju");
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }
  
@Override
public int register(User user) {
	String sql = "insert into users values(?,?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(),user.getRole() });
}


@Override
public String getUserRole(String user) {
	
String sql = "select * from users where username="+'"'+user+'"';
System.out.println("sql  "+sql);
List<User> users = jdbcTemplate.query(sql, new UserMapper());
//String numOfrole = jdbcTemplate.queryForObject(sql, String.class);
//SqlRowSet srole=jdbcTemplate.queryForRowSet(sql);
return "hello";

}
}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));
    user.setRole(rs.getString("role"));
System.out.println("role:--"+user.getRole());
    return user;
  }
}