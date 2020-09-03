/**
 * 
 */
package com.stackroute.authenticationservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.service.SecurityTokenGenerator;
import com.stackroute.authenticationservice.service.UserService;

/**
 * @author siranjeevi
 *
 */
@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/userservice")
public class UserController {
	
	
	private ResponseEntity<?> response;
	@Autowired
	private UserService service;
	@Autowired
	private SecurityTokenGenerator generator;

	
	public UserController(UserService service, SecurityTokenGenerator generator) {
		this.service = service;
		this.generator = generator;
	}
	
//	@PostMapping("/save")
//	public ResponseEntity<?> saveUser(@RequestBody User user) {
//		service.saveUser(user);
//		return response = new ResponseEntity<>(user, HttpStatus.CREATED);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> findByUserNameAndPassword(@RequestBody User user) throws UserNotFoundException {
		Map<String, String> map = null;
		try {
			User obj = service.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			if (obj.getUserName().equalsIgnoreCase(user.getUserName())) 
				map = generator.generateToken(user);
			response = new ResponseEntity<>(map, HttpStatus.OK);
			
		} catch (UserNotFoundException ue) {
			throw new UserNotFoundException();
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage() + " Try after some time !!", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
