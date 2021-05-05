package com.javaStack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaStack.entity.User;
import com.javaStack.services.SignupService;

@RestController
@RequestMapping("/api/signup")
@CrossOrigin
public class SignupController {
	
	@PostMapping()
	String signupUser(@RequestBody User newUser) {
		SignupService signup1 = new SignupService();
		return signup1.signupUser(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getPassword());
	  }
	
	// POST for LOGIN with credential

}
