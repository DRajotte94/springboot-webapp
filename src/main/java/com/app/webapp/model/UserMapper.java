package com.app.webapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserModel user = new UserModel(
				rs.getInt("user_id"), 
				rs.getString("username"),
				rs.getString("password"), 
				rs.getString("email"), 
				rs.getString("phone")
			);
		return user;
	}

}
