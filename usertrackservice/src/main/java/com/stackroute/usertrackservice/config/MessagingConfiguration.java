package com.stackroute.usertrackservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class MessagingConfiguration {
	
	private String exchange = "user_exchange";
	private String registrationQueue = "user_queue";
	private String trackQueue = "user_track";
	
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	@Primary
	Queue registerQueue() {
		return new Queue(registrationQueue, false);
	}
	
	@Bean
	Queue trackQueue() {
		return new Queue(trackQueue, false);
	}
	
	
	@Bean
	Binding bindingUser(Queue registerQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(registerQueue()).to(directExchange).with("user_routing");
	}
	
	
	@Bean
	Binding bindingTrack(Queue trackQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(trackQueue()).to(directExchange).with("track_routing");
	}
	
	@Bean
	public Jackson2JsonMessageConverter jacksonConvertor() {
		return new Jackson2JsonMessageConverter();
	}
	
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jacksonConvertor());
		 return rabbitTemplate;
	}

}
