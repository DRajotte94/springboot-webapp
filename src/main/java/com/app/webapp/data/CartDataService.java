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

import com.app.webapp.model.CartModel;
import com.app.webapp.model.CartMapper;

@Repository
@Primary
public class CartDataService implements CartDataAccessInterface {

	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CartModel> viewCart() {
		List<CartModel> cart = jdbcTemplate.query("SELECT * FROM cart", new CartMapper());
		return cart;
	}
	
	@Override
	public long addToCart(CartModel cart) {
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleInsert.withTableName("cart").usingGeneratedKeyColumns("cart_id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("user", cart.getUser());
		parameters.put("product_name", cart.getProduct_name());
		parameters.put("product_type", cart.getProduct_type());
		parameters.put("qty", cart.getQty());
		parameters.put("price", cart.getPrice());
		
		Number result = simpleInsert.executeAndReturnKey(parameters);
		
		return result.longValue();
	}
	
	@Override
	public CartModel updateCart(CartModel cart) {
		jdbcTemplate.update("UPDATE cart SET user = ?, product_name = ?, product_type = ?, qty = ?, price = ? WHERE cart_id = ?", 
				cart.getUser(),
				cart.getProduct_name(),
				cart.getProduct_type(),
				cart.getQty(),
				cart.getPrice(),
				cart.getCart_id()
			);
		
		return cart;
	}
	
	@Override
	public boolean deleteCartItem(int id) {
		int result = jdbcTemplate.update("DELETE FROM cart WHERE cart_id = ?", id);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean clearCart(List<CartModel> cart) {
		int result = 0;
		
		for (CartModel item : cart) {
			jdbcTemplate.update("DELETE FROM cart WHERE cart_id = ?", item.getCart_id());
			result += 1;
		}
		
		if (result == cart.size()) {
			return true;
		} else {
			return false;
		}
	}

}
