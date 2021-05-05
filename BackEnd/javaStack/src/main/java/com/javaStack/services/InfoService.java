package com.javaStack.services;

import java.util.ArrayList;
import java.util.List;

import com.javaStack.dao.GetUsersDao;
import com.javaStack.entity.User;
import com.javaStack.entity.UserDetail;

public class InfoService {
	
	public List<User> userList(String email, String password) {
		GetUsersDao userLogin = new GetUsersDao();
		try{
		List<User> userArr = userLogin.getAllUsers();
		List<UserDetail> res = new ArrayList<UserDetail>();
			for(User u : userArr) {
				UserDetail a = new UserDetail();
				a.setFirstName(u.getFirstName());
				a.setLastName(u.getLastName());
				res.add(a);
			}
			return userArr;
		}
		catch(Exception e) {
			return null;
		}
	}
}
