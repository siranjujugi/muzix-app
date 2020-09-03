/**
 * 
 */
package com.stackroute.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.repository.UserRepository;

/**
 * @author siranjeevi
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository repository;
	

	@Override
	public User saveUser(User user) {
		//With default constructor
		return repository.save(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
		User user = repository.findByUserNameAndPassword(userName, password);
		if (user == null)
			throw new UserNotFoundException();
		
		return user;
	}

}
