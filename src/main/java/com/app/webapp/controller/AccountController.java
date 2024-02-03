package com.app.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.webapp.model.UserModel;
import com.app.webapp.services.UserBusinessServiceInterface;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	UserBusinessServiceInterface service;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String register(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "registration";
	}
	
	@PostMapping("/registration/process")
	public String createUser(UserModel newUser, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		if (service.isUsernameAvailable(newUser)) {
			System.out.println("New user created: " + service.addUser(newUser));
			return "confirm";
		} else {
			bindingResult.addError(new ObjectError("username", "The username you entered is already taken."));
			return "registration";
		}
	}
	
	@GetMapping("/reset")
	public String resetPassword() {
		return "reset";
	}

}
