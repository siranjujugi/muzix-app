/**
 * 
 */
package com.stackroute.orchestrationservice.service;


import com.stackroute.orchestrationservice.domain.User;
import com.stackroute.orchestrationservice.exception.UserAlreadyExistsException;

/**
 * @author siranjeevi
 *
 */
public interface OrchestrationService {
	
	public User registerUser(User user) throws UserAlreadyExistsException;
	
	
}
