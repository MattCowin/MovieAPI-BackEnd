package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.User;
import com.revature.service.MovieService;
import com.revature.service.UserService;

public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MovieService movieService = context.getBean("movieService",MovieService.class);
		UserService userService = context.getBean("userService", UserService.class);
		
		logger.trace(userService.registerUser(new User(1, "TonyStark", "1234")));
		
		
		// Log out to console the Heroes we set for testing. Avoid using sysout when log4j available.
		//logger.trace(userService.getAllUsers());
		
		// Retrieve a given hero
		logger.trace("*** Finding User: " + userService.getUser("TonyStark"));
		
		
		
		
		
		

		
	}
}
