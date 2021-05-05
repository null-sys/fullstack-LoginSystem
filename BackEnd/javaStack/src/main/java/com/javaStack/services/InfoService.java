package com.javaStack.services;

import java.util.ArrayList;
import java.util.List;

import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.User;
import com.javaStack.entity.UserDetail;
import com.javaStack.security.JWT;

public class InfoService {
	
	public List<UserDetail> userList(String jwt) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		String email = JWT.getEmailJWT(jwt);
		User user1 = userLogin.getOneUser(email);
		
		if(user1 != null) {
		List<User> userArr = userLogin.getAllUsers();
		List<UserDetail> res = new ArrayList<UserDetail>();
			for(User u : userArr) {
				UserDetail a = new UserDetail();
				a.setFirstName(u.getFirstName());
				a.setLastName(u.getLastName());
				res.add(a);
			}
			return res;
		}
		else 
			return null;
		}
		catch(Exception e) {
			return null;
		}
		
	}
}
