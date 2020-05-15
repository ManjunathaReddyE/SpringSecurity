package com.jcg.dao;

import com.jcg.model.Login;
import com.jcg.model.User;

public interface UserDao {

  int register(User user);
  User validateUser(Login login);
  String getUserRole(String username);
}
