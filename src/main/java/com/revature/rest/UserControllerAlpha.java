package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ajax.ClientMessage;
import com.revature.model.Users;
import com.revature.service.UserService;
@RestController("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerAlpha implements UserController{
	
	private static Logger logger = Logger.getLogger(UserControllerAlpha.class);
	@Autowired
	private UserService userService;
	@PostMapping(value="/register")
	public ClientMessage registerUser(@RequestBody Users user) {
		logger.trace("Registering a new user " + user);
		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WENT_WRONG;
	}

	@PostMapping(value="/findUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users findUser(@RequestBody Users user, HttpServletRequest request) {
		logger.trace("Finding user " + user);
		request.getSession();
		return userService.getUser(user.getUsername());
	}

	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping(value="/login")
    public boolean login(@RequestBody Users user, HttpServletRequest request) {
		logger.trace("Attempted to log in: " + user);
        return
          user.getUsername().equals("username") && user.getPassword().equals("password");
    }
    

	
}
