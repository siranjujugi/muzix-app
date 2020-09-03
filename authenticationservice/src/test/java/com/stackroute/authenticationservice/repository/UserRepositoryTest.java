package com.stackroute.authenticationservice.repository;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.authenticationservice.domain.User;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
		user.setUserName("Siranj");
		user.setPassword("Siranj123");
	}
	
	@After
	public void tearDown() {
		repo.deleteAll();
		user = null;
	}

	@Test
	public void testSave() {
		user = repo.save(user);
		User obj= repo.findById(user.getUserId()).get();
		Assert.assertEquals(user.getUserName(), obj.getUserName());
		repo.delete(user);
	}
	
	@Test
	public void testLogin() {
		user = repo.save(user);
		User obj= repo.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		Assert.assertEquals(user.getUserName(), obj.getUserName());
		repo.delete(user);
	}

}
