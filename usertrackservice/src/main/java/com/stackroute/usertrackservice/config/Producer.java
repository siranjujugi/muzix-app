/**
 * 
 */
package com.stackroute.usertrackservice.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.usertrackservice.rabbitmq.domain.UserDTO;

/**
 * @author siranjeevi
 *
 */
@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private DirectExchange exchange;
	
	public void sendMessage(UserDTO userDTO) {
		rabbitTemplate.convertAndSend(exchange.getName(), "user_routing", userDTO);
	}
	
	public void sendTrackMessage(UserDTO userDTO) {
		rabbitTemplate.convertAndSend(exchange.getName(), "track_routing", userDTO);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
