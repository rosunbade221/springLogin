package login.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.config.WebSecurityConfig;
import login.domain.Users;
import login.manager.UserManager;
import login.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;
	
	@RequestMapping("/signup")
	public String signup(Principal principal) {
		
		if (principal != null && ((Authentication) principal).isAuthenticated()) {
			return "home";
		} else {
			
			return "signup";
		}
	}

	@RequestMapping(value = {"/home","/"})
	public String home(Principal principal){
		if (principal != null && ((Authentication) principal).isAuthenticated()) {
			return "home";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/login")
	public String login(Principal principal){
	
		if (principal != null && ((Authentication) principal).isAuthenticated()) {
			return "home";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/createUser")
	public String createUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, 
			@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("role") String role){
		Users user = new Users();
		user.setUsername(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRole(role);
		userManager.createUser(user);
		return "login";
	}
	
}
