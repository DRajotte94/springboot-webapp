package com.app.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.webapp.data.UserDataAccessInterface;
import com.app.webapp.model.UserModel;

public class UserBusinessService implements UserBusinessServiceInterface {
	
	@Autowired
	UserDataAccessInterface userDAO;

	@Override
	public boolean isUsernameAvailable(UserModel user) {
		return userDAO.isUsernameAvailable(user);
	}
	
	@Override
	public long addUser(UserModel user) {
		return userDAO.addUser(user);
	}

}
