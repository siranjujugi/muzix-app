package com.stackroute.authenticationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class MessagingConfiguration {
	
	
	@Bean
	public MessageConverter messageConvertor() {
		return new Jackson2JsonMessageConverter();
	}
	
//	private String exchange = "user_exchange";
//	private String registrationQueue = "user_queue";
//	
//	@Bean
//	DirectExchange directExchange() {
//		return new DirectExchange(exchange);
//	}
//	
//	@Bean
//	Queue registerQueue() {
//		return new Queue(registrationQueue, false);
//	}
//	
//	@Bean
//	Binding bindingUser(Queue registrationQueue, DirectExchange directExchange) {
//		return BindingBuilder.bind(registerQueue()).to(directExchange).with("user_routing");
//	}
//	
//	@Bean
//	public Jackson2JsonMessageConverter jacksonConvertor() {
//		return new Jackson2JsonMessageConverter();
//	}
//	
//	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(jacksonConvertor());
//		 return rabbitTemplate;
//	}

}
