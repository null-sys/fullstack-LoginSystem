package com.javaStack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaStack.entity.JWTReturn;
import com.javaStack.entity.LoginModel;
import com.javaStack.services.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
	// GET for JWT authentication
	@GetMapping
	public JWTReturn jwtLogin(@RequestHeader("jwt") String  jwt){
		LoginService loginServ1 = new LoginService();
		return loginServ1.verifyLogin(jwt);
	}
	
	@PostMapping()
	public JWTReturn loginUser(@RequestBody LoginModel newLogin) {
		LoginService loginServ1 = new LoginService();
		return loginServ1.login(newLogin.getEmail(), newLogin.getPassword());
	  }
	
	// POST for LOGIN with credential

}
