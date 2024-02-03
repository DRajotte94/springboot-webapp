package com.app.webapp.services;

import java.util.List;

import com.app.webapp.model.CartModel;

public interface CartBusinessServiceInterface {
	
	public List<CartModel> viewCart();
	public long addToCart(CartModel cart);
	public CartModel updateCart(CartModel cart);
	public boolean deleteCartItem(int id);
	public boolean clearCart(List<CartModel> cart);

}
