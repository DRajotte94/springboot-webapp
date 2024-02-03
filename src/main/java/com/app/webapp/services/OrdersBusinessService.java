package com.app.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.webapp.data.OrdersDataAccessInterface;
import com.app.webapp.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {
	
	@Autowired
	OrdersDataAccessInterface ordersDAO;

	@Override
	public List<OrderModel> getOrders() {
		return ordersDAO.getOrders();
	}

	@Override
	public long createOrder(OrderModel order) {
		return ordersDAO.createOrder(order);
	}

	@Override
	public boolean deleteOrder(int id) {
		return ordersDAO.deleteOrder(id);
	}

}
