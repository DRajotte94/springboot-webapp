package com.app.webapp.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.app.webapp.model.UserMapper;
import com.app.webapp.model.UserModel;

@Repository
@Primary
public class UserDataService implements UserDataAccessInterface {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isUsernameAvailable(UserModel user) {
		List<UserModel> users = jdbcTemplate.query("SELECT * FROM users", new UserMapper());
		for (UserModel account : users) {
			if (user.getUsername().equals(account.getUsername())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public long addUser(UserModel newUser) {
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleInsert.withTableName("users").usingGeneratedKeyColumns("user_id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("username", newUser.getUsername());
		parameters.put("password", newUser.getPassword());
		parameters.put("email", newUser.getEmail());
		parameters.put("phone", newUser.getPhone());
		
		Number result = simpleInsert.executeAndReturnKey(parameters);
		
		return result.longValue();
	}

}
