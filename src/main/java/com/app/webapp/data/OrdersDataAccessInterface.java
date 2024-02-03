package com.app.webapp.data;

import java.util.List;

import com.app.webapp.model.OrderModel;

public interface OrdersDataAccessInterface {
	
	public List<OrderModel> getOrders();
	public long createOrder(OrderModel order);
	public boolean deleteOrder(int id);

}
