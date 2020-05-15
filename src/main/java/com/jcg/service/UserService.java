/*@Interface UserService
 * This interface contains the declaration of BL they are all of abstract in nature*/
package com.jcg.service;

import com.jcg.model.Login;
import com.jcg.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
  
  String getUserRole(String username);
}
