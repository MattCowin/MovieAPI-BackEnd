package com.revature.service;


import com.revature.model.Users;

public interface UserService {

		public Users getUser(String username);
		public boolean registerUser(Users user);
		
		
}
