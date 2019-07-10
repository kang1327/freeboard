package com.raon.raonqna.kms.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.raon.raonqna.kms.service.JoinService;
import com.raon.raonqna.kms.service.LoginService;
@Controller
public class UsersController {

	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> paraMap) {
		String userId = paraMap.get("user_id");
		String userPw = paraMap.get("user_pw");
		String userName = paraMap.get("user_name");
		
		String page = joinService.joinUser(userId, userPw,userName);
		
		return page;
	}
	@PostMapping(value="/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paraMap) {
		
		String userId = paraMap.get("user_id");
		String userPw = paraMap.get("user_pw");
		
		String page = loginService.login(userId, userPw);
		return page;
	}

}


