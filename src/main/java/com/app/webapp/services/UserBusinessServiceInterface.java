package com.app.webapp.services;

import com.app.webapp.model.UserModel;

public interface UserBusinessServiceInterface {
	
	public boolean isUsernameAvailable(UserModel user);
	public long addUser(UserModel user);

}
