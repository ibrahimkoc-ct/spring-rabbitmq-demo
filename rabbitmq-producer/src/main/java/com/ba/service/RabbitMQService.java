package com.ba.service;

import com.ba.model.Customer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${sp.rabbitmq.exchange}")
	private String exchange;

	@Value("${sp.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Customer customer) {
		amqpTemplate.convertAndSend(exchange, routingkey, customer);
		System.out.println("Send msg = " + customer.toString());
	    
	}
}