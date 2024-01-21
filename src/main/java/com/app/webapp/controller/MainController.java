package com.app.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovy.util.logging.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/orders")
	public String showOrders() {
		return "orders";
	}
	
	@GetMapping("/create")
	public String showCreate() {
		return "create";
	}

}
