package com.javaStack.services;

import com.javaStack.dao.AddUserDao;
import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.JWTReturn;
import com.javaStack.entity.User;
import com.javaStack.security.JWT;

public class SignupService {
	
	public JWTReturn signupUser(String fName, String lName, String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null) {
			return null;
		}else {
			AddUserDao addUser1 = new AddUserDao();
			Boolean a  = addUser1.registerUser(fName, lName, email, password);
			if(a) {
				JWTReturn res = new JWTReturn();
				res.setJwtString(JWT.createJWT(email, 10000000));
				res.setUser(email);
				return res;
			}
		}
		
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
}
