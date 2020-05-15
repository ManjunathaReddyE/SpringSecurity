/*className:RegistrationController.java
 * This is the controller class about the  request comming from register page*/
package com.jcg.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jcg.model.User;
import com.jcg.service.UserService;

@Controller
public class RegistrationController {
	 DBUtil util=new DBUtil();
 
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    //mav.addObject("user", new User());
     return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {
	  System.out.println("registration control----");
	  util.insertuser(user);
	  System.out.println(" user "+user.getRole());
	  return new ModelAndView("regsuccess");
  }
  List<User> userlist=new ArrayList<User>();
 @RequestMapping(value = "/fetchUserLlist", method = RequestMethod.GET)
  public ModelAndView fetchUserLlist(HttpServletRequest request, HttpServletResponse response)
     {
	 
	 ModelAndView mv=new ModelAndView();
	  System.out.println("fetching userlist in  reg controller----");
	  DBUtil util=new DBUtil();
	  userlist= util.fetchUserList();
	  this.setUserlist(userlist);
	  mv.addObject("userlist", userlist);
	  mv.setViewName("userList");
	  return mv;
  }

public List<User> getUserlist() {
	return userlist;
}

public void setUserlist(List<User> userlist) {
	this.userlist = userlist;
}
}
