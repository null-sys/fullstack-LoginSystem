package com.javaStack.entity;

public class JWTReturn {

	
	private String jwtString;
	public String getJwtString() {
		return jwtString;
	}
	public void setJwtString(String jwtString) {
		this.jwtString = jwtString;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private String user;

}
