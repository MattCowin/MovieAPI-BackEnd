package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.repository.UserRepository;

public class UserServiceAlpha implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceAlpha.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceAlpha() {
		
	}
	
	public UserServiceAlpha(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean registerUser(User user) {
		userRepository.save(user);
		return user.getId() !=0;
	}


}
