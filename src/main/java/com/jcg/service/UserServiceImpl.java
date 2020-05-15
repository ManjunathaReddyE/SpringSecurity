package com.jcg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jcg.dao.UserDao;
import com.jcg.model.Login;
import com.jcg.model.User;


public class UserServiceImpl implements UserService {
	
/*Spring IOC feature:- Injection of Dao's*/
  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }


public String getUserRole(String username) {
	
	return userDao.getUserRole(username);
}

}
