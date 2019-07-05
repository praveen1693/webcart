package com.webcart.entity;

public class Product {
	private String pid;
	private String price;
	private int quantity;

	public Product(String pid, String price, int quantity) {
		super();
		this.pid = pid;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String pid, String price) {
		super();
		this.pid = pid;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", price=" + price + "]";
	}

}
