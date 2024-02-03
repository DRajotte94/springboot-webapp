package com.app.webapp.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.webapp.model.CartModel;
import com.app.webapp.model.OrderModel;
import com.app.webapp.model.ProductModel;
import com.app.webapp.services.CartBusinessServiceInterface;
import com.app.webapp.services.OrdersBusinessServiceInterface;
import com.app.webapp.services.ProductBusinessServiceInterface;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrdersBusinessServiceInterface service;
	@Autowired
	ProductBusinessServiceInterface productService;
	@Autowired
	CartBusinessServiceInterface cartService;
	
	@GetMapping("/")
	public String showOrders(Model model) {
		List<OrderModel> orders = service.getOrders();
		model.addAttribute("orders", orders);
		return "orders";
	}
	
	@GetMapping("/submit")
	public String createOrder(Model model) {
		List<CartModel> cart = cartService.viewCart();
		OrderModel order = new OrderModel();
		
		order.setUser("drajotte"); // needs to be updated to match logged in user
		
		for (CartModel item : cart) {
			order.setItems(order.getItems() + item.getProduct_name() + " x" + item.getQty() + ", ");
			order.setPrice(order.getPrice() + item.getPrice());
		}

		service.createOrder(order);
		cartService.clearCart(cart);
		
		return "confirm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable(name="id") int id) {
		System.out.println("Deleted product number: " + id + " " + service.deleteOrder(id));
		return "confirm";
	}

}
