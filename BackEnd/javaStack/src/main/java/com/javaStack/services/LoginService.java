package com.javaStack.services;

import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.JWTReturn;
import com.javaStack.entity.User;
import com.javaStack.security.JWT;
import com.javaStack.security.SecurePassword;

public class LoginService {
	
	public JWTReturn login(String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		JWTReturn res = new JWTReturn();
		try{
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null && SecurePassword.verifyPassword(password, user1.getPassword())) {
			res.setJwtString(JWT.createJWT(email, 10000000));
			res.setUser(email);
			return res;
		}else {
			return null;
		}
		
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public JWTReturn verifyLogin(String jwt) {
		
		GetUsersDao userLogin = new GetUsersDao();
		try{
		String email = JWT.getEmailJWT(jwt);
		User user1 = userLogin.getOneUser(email);
		JWTReturn res = new JWTReturn();
		
		if(user1 != null) {
			res.setJwtString(JWT.createJWT(email, 10000000));
			res.setUser(email);
			return res;
		}else {
			return null;
		}
		
		}
		catch(Exception e) {
			return null;
		}
	}

}
