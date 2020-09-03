/**
 * 
 */
package com.stackroute.authenticationservice.service;

import java.util.Map;

import com.stackroute.authenticationservice.domain.User;

/**
 * @author siranjeevi
 *
 */
public interface SecurityTokenGenerator {
	
	public Map<String, String> generateToken (User user);

}
