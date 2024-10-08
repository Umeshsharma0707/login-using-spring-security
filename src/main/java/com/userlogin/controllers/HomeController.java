package com.userlogin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userlogin.Service.UserService;
import com.userlogin.models.Users;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.service.saveUser(user);
		return "login";
	}
}
