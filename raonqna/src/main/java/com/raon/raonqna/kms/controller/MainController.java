package com.raon.raonqna.kms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
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

}
