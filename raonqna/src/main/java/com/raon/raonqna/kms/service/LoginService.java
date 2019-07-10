package com.raon.raonqna.kms.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raon.raonqna.kms.Model.Users;
import com.raon.raonqna.kms.repository.UsersRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	HttpSession session;
	
	public String login(String userId, String userPw) {
		if(userId.equals("") || userPw.equals("")) {
			return "login";
		}
		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
		
		Users users = usersRepository.findByUseridAndPassword(userId, hashedPassword);
		if(users == null) {
			return "login";
		}
		
		session.setAttribute( "loginUser",users);
		return "index";
	}
	


}
