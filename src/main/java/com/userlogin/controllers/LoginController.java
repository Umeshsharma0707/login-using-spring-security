package com.userlogin.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.userlogin.Service.UserPrincipal;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("dashboard")
	public String dashboard(@AuthenticationPrincipal UserPrincipal userPrincipal , Model model ) {
		String username = userPrincipal.getUsername();
		model.addAttribute("username", username);
		return "dashboard";
	}
}
