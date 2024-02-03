package com.app.webapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CartMapper implements RowMapper<CartModel> {

	@Override
	public CartModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CartModel cart = new CartModel(
				rs.getInt("cart_id"),
				rs.getString("user"),
				rs.getString("product_name"),
				rs.getString("product_type"),
				rs.getInt("qty"),
				rs.getDouble("price")
			);
		
		return cart;
	}

}
