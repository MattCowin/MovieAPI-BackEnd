package com.revature.rest;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;

import com.revature.model.Users;

public interface UserController {

	ClientMessage registerUser(Users user);
	Users findUser(Users user, HttpServletRequest request);
}
