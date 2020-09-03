/**
 * 
 */
package com.stackroute.authenticationservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.stackroute.authenticationservice.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author siranjeevi
 *
 */
@Component
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{

	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = null;
		jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		
		Map<String, String> details = new HashMap<>();
		details.put("token", jwtToken);
		details.put("message", "User successfully logged in");
		return details;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
