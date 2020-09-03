/**
 * 
 */
package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;

/**
 * @author siranjeevi
 *
 */
public interface UserService {
	
	public User saveUser(User user);
	
	public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException;

}
