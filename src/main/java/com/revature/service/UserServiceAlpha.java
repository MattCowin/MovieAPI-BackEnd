package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.model.Users;
import com.revature.repository.UserRepository;

@Service("userService")
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
	public Users getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean registerUser(Users user) {
		userRepository.save(user);
		return user.getUserId() !=0;
	}




}
