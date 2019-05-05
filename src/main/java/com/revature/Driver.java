package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.api.PopularMovies;

import com.revature.model.Users;
import com.revature.service.MovieService;
import com.revature.service.UserService;



public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//		UserService userService = context.getBean("userService", UserService.class);
//		logger.trace(userService.registerUser(new User(0, "Cowin", "1234")));
//	
		

		//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Chris\\OneDrive\\Documents\\Software Development\\Workspaces\\sts4\\Project2\\Project2MovieAPI\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");
		//ApplicationContext context = new FileSystemXmlApplicationContext("..\\WEB-INF\\applicationContext.xml");
		
		MovieService movieService = context.getBean("movieService",MovieService.class);
		UserService userService = context.getBean("userService", UserService.class);
		PopularMovies popMoviesService = context.getBean(PopularMovies.class);
		
		logger.trace(userService.registerUser(new Users(1, "TonyStark", "1234")));
		
		
		// Log out to console the Heroes we set for testing. Avoid using sysout when log4j available.
		//logger.trace(userService.getAllUsers());
		
		// Retrieve a given hero
		logger.trace("*** Finding User: " + userService.getUser("TonyStark"));
		
		
	}	
		
}
