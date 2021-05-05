package com.javaStack.services;

import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.User;
import com.javaStack.security.JWT;
import com.javaStack.security.SecurePassword;

public class LoginService {
	
	public String login(String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null && SecurePassword.verifyPassword(password, user1.getPassword())) {
			return JWT.createJWT(email, 10000000);
		}else {
			return "Incorrect credential";
		}
		
		}
		catch(Exception e) {
			return e.toString();
		}
	}
	
	public String verifyLogin(String jwt) {
		
		GetUsersDao userLogin = new GetUsersDao();
		try{
		String email = JWT.getEmailJWT(jwt);
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null) {
			return jwt;
		}else {
			return "Incorrect credential";
		}
		
		}
		catch(Exception e) {
			return e.toString();
		}
	}

}
