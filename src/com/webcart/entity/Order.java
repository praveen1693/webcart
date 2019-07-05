package com.webcart.entity;

import java.util.Date;

public class Order {
	private String user;
	private String orderId;
	private float subtotal;
	private float tax;
	private float grandtotal;
	private Date orderDate;
	private Date dlvDate;
	private String status;
	public Order(String user, String orderId, float subtotal, float tax, float grandtotal, Date orderDate, Date dlvDate,
			String status) {
		super();
		this.user = user;
		this.orderId = orderId;
		this.subtotal = subtotal;
		this.tax = tax;
		this.grandtotal = grandtotal;
		this.orderDate = orderDate;
		this.dlvDate = dlvDate;
		this.status = status;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(float grandtotal) {
		this.grandtotal = grandtotal;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDlvDate() {
		return dlvDate;
	}
	public void setDlvDate(Date dlvDate) {
		this.dlvDate = dlvDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [user=" + user + ", orderId=" + orderId + ", subtotal=" + subtotal + ", tax=" + tax
				+ ", grandtotal=" + grandtotal + ", orderDate=" + orderDate + ", dlvDate=" + dlvDate + ", status="
				+ status + "]";
	}
}
