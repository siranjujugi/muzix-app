package com.stackroute.authenticationservice.controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.service.SecurityTokenGenerator;
import com.stackroute.authenticationservice.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService service;
	
	@MockBean
	private SecurityTokenGenerator generator;
	
	private User user;
	
	@InjectMocks
	private UserController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		user = new User();
		user.setUserName("siranj");
		user.setPassword("siranj");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() throws Exception {
		
		when(service.saveUser(any())).thenReturn(user);
		
		mockMvc.perform(
				post("/api/v1/userservice/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(user)))
				.andExpect(status().isCreated());
		
		
		verify(service, times(1)).saveUser(any());
		
	}
	
	@Test
	public void testLogin() throws Exception {
		when(service.saveUser(any())).thenReturn(user);
		
		when(service.findByUserNameAndPassword(user.getUserName(), user.getPassword())).thenReturn(user);
		
		
		mockMvc.perform(
				post("/api/v1/userservice/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(user)))
				.andExpect(status().isOk());
		verify(service, times(1)).findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}
	
	private static String jsonToString(final Object obj) {
		String json;
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			json = e.getMessage();
			e.printStackTrace();
		}
		return json;
	}


}
