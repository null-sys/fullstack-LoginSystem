package com.javaStack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaStack.entity.LoginModel;
import com.javaStack.services.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
	// GET for JWT authentication
	@GetMapping
	public String sayHii() {
		String a = "Hii";
		return a;
	}
	
	@PostMapping()
	String loginUser(@RequestBody LoginModel newLogin) {
		LoginService loginServ1 = new LoginService();
		return loginServ1.login(newLogin.getEmail(), newLogin.getPassword());
	  }
	
	// POST for LOGIN with credential

}
