package com.app.webapp.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.webapp.model.CartModel;
import com.app.webapp.model.ProductModel;
import com.app.webapp.services.CartBusinessServiceInterface;
import com.app.webapp.services.ProductBusinessServiceInterface;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartBusinessServiceInterface service;
	@Autowired
	ProductBusinessServiceInterface productService;
	
	@GetMapping("/")
	public String viewCart(Model model) {
		List<CartModel> cart = service.viewCart();
		
		double total = 0;
		for (CartModel item : cart) {
			total += item.getPrice();
		}
		
		DecimalFormat df = new DecimalFormat("####0.00");
		
		model.addAttribute("cart", cart);
		model.addAttribute("total", df.format(total));
		
		return "cart";
	}
	
	@GetMapping("/add/{id}")
	public String addToCart(@PathVariable(name="id") int id) {
		ProductModel product = productService.getById(id);
		System.out.println(product);
		List<CartModel> currentCart = service.viewCart();
		
		// check each item in cart to see if it matches new item, if it does then update and set updated to true
		boolean updated = false;
		for (CartModel item : currentCart) { 
			if (item.getProduct_name().equals(product.getName())) {
				item.setQty(item.getQty() + 1);
				item.setPrice(item.getPrice() + product.getPrice());
				service.updateCart(item);
				updated = true;
			}
		}
		if (updated == false) { // if item was not found in current cart then add to cart
			CartModel cart = new CartModel(0, "drajotte", product.getName(), product.getType(), 1, product.getPrice());	
			service.addToCart(cart);
		}
		
		return "confirm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		System.out.println("Deleted product number: " + id + " " + service.deleteCartItem(id));
		return "confirm";
	}

}
