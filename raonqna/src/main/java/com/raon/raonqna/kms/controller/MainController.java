package com.raon.raonqna.kms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/joinPage")
	public String joinPage() {
		return "join";
	}
	
	@GetMapping("/loginPage")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logoutPage")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/freeboardWritePage")
	public String freeboardWritePage() {
		return "freeboardWrite";
	}

}
