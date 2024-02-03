package com.app.webapp.model;

public class CartModel {
	private int cart_id = 0;
	private String user = "";
	private String product_name = "";
	private String product_type = "";
	private int qty = 0;
	private double price = 0;
	
	public CartModel() {
		super();
	}

	public CartModel(int cart_id, String user, String product_name, String product_type, int qty, double price) {
		super();
		this.cart_id = cart_id;
		this.user = user;
		this.product_name = product_name;
		this.product_type = product_type;
		this.qty = qty;
		this.price = price;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartModel [cart_id=" + cart_id + ", user=" + user + ", product_name=" + product_name + ", product_type="
				+ product_type + ", qty=" + qty + ", price=" + price + "]";
	}

}
