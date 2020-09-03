/**
 * 
 */
package com.stackroute.orchestrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.orchestrationservice.domain.User;
import com.stackroute.orchestrationservice.exception.UserAlreadyExistsException;
import com.stackroute.orchestrationservice.service.OrchestrationService;

/**
 * @author siranjeevi
 *
 */
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin("*")
public class OrchestrationController {

	@Autowired
	private OrchestrationService service;

	@PostMapping("user")
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<?> registerAndSave(@RequestBody User user) throws UserAlreadyExistsException {

		try {
			User result = service.registerUser(user);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (UserAlreadyExistsException te) {
			throw new UserAlreadyExistsException();
		} catch (Exception e) {
			return constructInternalServerException(e);
		}

	}

	// TODO Move it to common class/utilities
	private ResponseEntity<?> constructInternalServerException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
