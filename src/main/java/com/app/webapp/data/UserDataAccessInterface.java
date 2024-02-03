package com.app.webapp.data;

import com.app.webapp.model.UserModel;

public interface UserDataAccessInterface {
	
	public boolean isUsernameAvailable(UserModel user);
	public long addUser(UserModel newUser);

}
