package com.javaStack.services;

import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.User;

public class LoginService {
	
	public String login(String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null && user1.getEmail() == email && user1.getPassword() == password) {
			return email;
		}else {
			return "Nothing available";
		}
		
		}
		catch(Exception e) {
			return e.toString();
		}
	}

}
