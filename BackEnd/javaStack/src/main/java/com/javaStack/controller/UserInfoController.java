package com.javaStack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public List<UserDetail> info(@RequestHeader("jwt") String  jwt) {
		return getInfo.userList(jwt);
		
	}
	
	// POST for LOGIN with credential

}
