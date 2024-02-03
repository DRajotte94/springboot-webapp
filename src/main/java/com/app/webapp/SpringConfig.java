package com.app.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.webapp.services.CartBusinessService;
import com.app.webapp.services.CartBusinessServiceInterface;
import com.app.webapp.services.OrdersBusinessService;
import com.app.webapp.services.OrdersBusinessServiceInterface;
import com.app.webapp.services.ProductBusinessService;
import com.app.webapp.services.ProductBusinessServiceInterface;
import com.app.webapp.services.UserBusinessService;
import com.app.webapp.services.UserBusinessServiceInterface;

@Configuration
public class SpringConfig {
	
	@Bean(name="productBusinessService")
	public ProductBusinessServiceInterface getProductBusiness() {
		return new ProductBusinessService();
	}
	
	@Bean(name="userBusinessService")
	public UserBusinessServiceInterface getUserBusiness() {
		return new UserBusinessService();
	}
	
	@Bean(name="ordersBusinessService")
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	@Bean(name="cartBusinessService")
	public CartBusinessServiceInterface getCartBusiness() {
		return new CartBusinessService();
	}
	
}
