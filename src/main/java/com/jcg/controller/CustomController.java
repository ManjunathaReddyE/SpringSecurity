/*class Name:-CustomController 
 * This  class is controller that filters the module redirection based on the request type
 *  */
package com.jcg.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jcg.dao.UserDaoImpl;
import com.jcg.model.Login;
import com.jcg.model.User;
import com.jcg.service.UserService;
import com.jcg.service.UserServiceImpl;

@Controller
public class CustomController {

	@RequestMapping(value = "/welcome")
	public ModelAndView welcomeUser(HttpServletRequest request, HttpServletResponse response) {

		DBUtil util = new DBUtil();
		String role = util.getUserRole(request.getRemoteUser());
		System.out.println("returing role: "+role);
		if (role.equals("admin")) {
			return new ModelAndView("welcome");
		} 
		else if (role.equals("customer")) {
			return new ModelAndView("customer");
		}
		else if (role.equals("manager")) {
			return new ModelAndView("manager");
		}
		else if (role.equals("agent")) {
			return new ModelAndView("agent");
		}
		else {
			ModelAndView mv=new ModelAndView();
			mv.addObject("errors", "username is Required");
			mv.setViewName("login");
			return mv;
		}
	}
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public ModelAndView agent() {
		return new ModelAndView("agent");
	}
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView manager() {
		return new ModelAndView("manager");
	}
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customerUser() {
		return new ModelAndView("customer");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
	return new ModelAndView("logout");
	}
}
