package com.app.webapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderModel order = new OrderModel(
				rs.getInt("order_num"), 
				rs.getString("user"),
				rs.getString("items"),
				rs.getDouble("price")
			);
		
		return order;
	}

}
