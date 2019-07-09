package com.raon.raonqna.kms.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.raon.raonqna.kms.repository.UsersRepository;
import com.raon.raonqna.kms.service.JoinService;
@Controller
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private JoinService joinService;
	
	@PostMapping("/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> paraMap) {
		String userId = paraMap.get("user_id");
		String userPw = paraMap.get("user_pw");
		String userName = paraMap.get("user_name");
		joinService.joinUser(userId, userPw,userName);
		
		return "index";
	}
	@PostMapping(value="/loginRequest")
	public String loginRequest() {
		return "index";
	}

}


