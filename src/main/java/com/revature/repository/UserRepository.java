package com.revature.repository;


import com.revature.model.Users;

public interface UserRepository {

		void save(Users user);
		Users findByUsername(String username);
		Users findByUserId(int id);
		boolean updateFavorites(Users updatedUser);
		
}
