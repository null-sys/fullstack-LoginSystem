package com.javaStack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaStack.entity.User;
import com.javaStack.entity.UserDetail;
import com.javaStack.services.InfoService;

@RestController
@RequestMapping("/api/info")
@CrossOrigin
public class UserInfoController {
	InfoService getInfo = new InfoService();
	
	@GetMapping
	public List<User> info() {
		return getInfo.userList("","");
		
	}
	
	// POST for LOGIN with credential

}
