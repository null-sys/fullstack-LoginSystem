package com.javaStack.services;

import com.javaStack.dao.AddUserDao;
import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.User;

public class SignupService {
	
	public String signupUser(String fName, String lName, String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null) {
			return "User Already Exists";
		}else {
			AddUserDao addUser1 = new AddUserDao();
			Boolean a  = addUser1.registerUser(fName, lName, email, password);
			if(a) {
				return "user Added";
			}
		}
		
		}
		catch(Exception e) {
			return e.toString();
		}
		return "User not added";
	}
}
