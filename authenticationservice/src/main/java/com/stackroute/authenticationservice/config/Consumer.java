/**
 * 
 */
package com.stackroute.authenticationservice.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.rabbitmq.domain.UserDTO;
import com.stackroute.authenticationservice.service.UserServiceImpl;


/**
 * @author siranjeevi
 *
 */
@Component
public class Consumer {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RabbitListener(queues = "user_queue")
	public void consumeMessage(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		
		userServiceImpl.saveUser(user);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
