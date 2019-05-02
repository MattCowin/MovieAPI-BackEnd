package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.User;
import com.revature.service.UserService;

public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = context.getBean("userService", UserService.class);
		logger.trace(userService.registerUser(new User(0, "Cowin", "1234")));
	}
}
