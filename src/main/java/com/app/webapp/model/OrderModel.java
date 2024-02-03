package com.app.webapp.model;

public class OrderModel {
	private int order_num = 0;
	private String user = "";
	private String items = "";
	private double price = 0;
	
	public OrderModel() {
		super();
	}

	public OrderModel(int order_num, String user, String items, double price) {
		super();
		this.order_num = order_num;
		this.user = user;
		this.items = items;
		this.price = price;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderModel [order_num=" + order_num + ", user=" + user + ", items=" + items + ", price=" + price + "]";
	}
	
}
