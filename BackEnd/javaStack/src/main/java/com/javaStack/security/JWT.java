package com.javaStack.security;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

public class JWT {
	public static String createJWT(String email, long ttlMillis) {
		//The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	   
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    ResourceBundle rb = ResourceBundle.getBundle("jwt-info");
	    String secretKey = rb.getString("jwt.secret");
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    
	    long expMillis = nowMillis + ttlMillis;
	    Date exp = new Date(expMillis);
	    //Let's set the JWT Claims
	    return Jwts.builder()
	            .claim("email", email)
	            .setSubject("jane")
	            .setId(UUID.randomUUID().toString())
	            .setIssuedAt(now)
	            .setExpiration(exp)
	            .signWith(signingKey)
	            .compact();
	     
	
	}
	
	static Jws<Claims> parseJwt(String jwtString) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		ResourceBundle rb = ResourceBundle.getBundle("jwt-info");
		String secretKey = rb.getString("jwt.secret");
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    return Jwts.parserBuilder()
	            .setSigningKey(signingKey)
	            .build()
	            .parseClaimsJws(jwtString);

	    
	}
	
	public static String getEmailJWT(String jwtString) {
		return (String) JWT.parseJwt(jwtString).getBody().get("email");
	}

}
