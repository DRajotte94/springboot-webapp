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

import com.app.webapp.model.OrderModel;
import com.app.webapp.model.OrdersMapper;

@Repository
@Primary
public class OrdersDataService implements OrdersDataAccessInterface {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<OrderModel> getOrders() {
		List<OrderModel> orders = jdbcTemplate.query("SELECT * FROM orders", new OrdersMapper());
		return orders;
	}
	
	@Override
	public long createOrder(OrderModel order) {
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleInsert.withTableName("orders").usingGeneratedKeyColumns("order_id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("user", order.getUser());
		parameters.put("items", order.getItems());
		parameters.put("price", order.getPrice());
		
		Number result = simpleInsert.executeAndReturnKey(parameters);
		
		return result.longValue();
	}

	@Override
	public boolean deleteOrder(int id) {
		int result = jdbcTemplate.update("DELETE FROM orders WHERE order_num = ?", id);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
