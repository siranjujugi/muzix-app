/**
 * 
 */
package com.stackroute.authenticationservice.service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.repository.UserRepository;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * @author siranjeevi
 *
 */
public class UserServiceTest {
	
	@Mock
	private UserRepository repo;
	private User user;
	
	@InjectMocks
	private UserServiceImpl service;
	
	Optional optional;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setUserName("siranj");
		user.setPassword("siranj");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		
		Mockito.when(repo.save(user)).thenReturn(user);
		User obj= service.saveUser(user);
		Assert.assertEquals(user.getUserName(), obj.getUserName());
		verify(repo, times(1)).save(user);
		
	}
	
	@Test
	public void testLogin() throws UserNotFoundException {
		Mockito.when(repo.findByUserNameAndPassword(user.getUserName(), user.getPassword())).thenReturn(user);
		User obj= service.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		Assert.assertEquals(user.getUserName(), obj.getUserName());
		verify(repo, times(1)).findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}

}
