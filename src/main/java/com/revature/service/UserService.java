package com.revature.service;

import com.revature.model.User;

public interface UserService {

		public User getUser(String username);
		public boolean registerUser(User user);
		
		
}
