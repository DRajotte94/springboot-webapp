package com.app.webapp.model;

public class ProductModel {
	
	private int productNumber = 0;
	private String type ="";
	private String name = "";
	private String description = "";
	private double price = 0;
	
	public ProductModel() {
		super();
	}

	public ProductModel(int num, String type, String name, String desc, double price) {
		this.productNumber = num;
		this.type = type;
		this.name = name;
		this.description = desc;
		this.price = price;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(int num) {
		this.productNumber = num;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductModel [productNumber=" + productNumber + ", type=" + type + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}

}
