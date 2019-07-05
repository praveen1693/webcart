package com.webcart.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> cart = new ArrayList<>();

	public Cart(List<Product> cart) {
		super();
		this.cart = cart;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}	
}
