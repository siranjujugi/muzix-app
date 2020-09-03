/**
 * 
 */
package com.stackroute.orchestrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.orchestrationservice.domain.User;
import com.stackroute.orchestrationservice.exception.UserAlreadyExistsException;



/**
 * @author siranjeevi
 *
 */
@Service
public class OrchestrationServiceImpl implements OrchestrationService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url-user:http://usertrackservice/api/v1/usertrackservice/register}")
	private String urlUserTrackService;
	
	
	@Value("${url-auth:http://authenticationservice/api/v1/userservice/save}")
	private String urlAuthenticationService;
	
	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
		
		User response = null;
		
		try {
			response = restTemplate.postForObject(urlUserTrackService, user, User.class);
			
			restTemplate.postForObject(urlAuthenticationService, user, User.class);
			
		} catch (Exception e) {
			throw new UserAlreadyExistsException();
		}
		
		return response;
	}

}
