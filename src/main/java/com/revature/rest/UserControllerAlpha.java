package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;

import com.revature.model.Users;
import com.revature.service.UserService;
@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerAlpha implements UserController{
	
	private static Logger logger = Logger.getLogger(UserControllerAlpha.class);
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody Users user) {
		logger.trace("Registering a new user " + user);
		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WENT_WRONG;
	}

	@PostMapping("/findUser")
	public @ResponseBody Users findUser(@RequestBody Users user, HttpServletRequest request) {
		logger.trace("Finding user " + user);
		request.getSession();
		return userService.getUser(user.getUsername());
	}

	

	
}
