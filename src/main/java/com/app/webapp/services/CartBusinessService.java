package com.app.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.webapp.data.CartDataAccessInterface;
import com.app.webapp.model.CartModel;

public class CartBusinessService implements CartBusinessServiceInterface {
	
	@Autowired
	CartDataAccessInterface service;

	@Override
	public List<CartModel> viewCart() {
		return service.viewCart();
	}

	@Override
	public long addToCart(CartModel cart) {
		return service.addToCart(cart);
	}

	@Override
	public CartModel updateCart(CartModel cart) {
		return service.updateCart(cart);
	}

	@Override
	public boolean deleteCartItem(int id) {
		return service.deleteCartItem(id);
	}

	@Override
	public boolean clearCart(List<CartModel> cart) {
		return service.clearCart(cart);
	}

}
