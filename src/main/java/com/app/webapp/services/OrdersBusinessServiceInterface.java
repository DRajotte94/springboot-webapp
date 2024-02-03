package com.app.webapp.services;

import java.util.List;

import com.app.webapp.model.OrderModel;

public interface OrdersBusinessServiceInterface {
	
	public List<OrderModel> getOrders();
	public long createOrder(OrderModel order);
	public boolean deleteOrder(int id);

}
