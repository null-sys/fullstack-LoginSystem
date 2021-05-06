package com.javaStack.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class SecurePassword {
	
	public static String encPassword(String password) {
		String salt = BCrypt.gensalt(10);
		return BCrypt.hashpw(password, salt);
	}
	
	public static Boolean verifyPassword(String plainPass , String hashPass) {
		return BCrypt.checkpw(plainPass, hashPass);
		
	}

}
