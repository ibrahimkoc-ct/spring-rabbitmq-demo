package com.ba.service;

import com.ba.model.Customer;
import com.ba.repository.CustomerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService {

    @Autowired
    CustomerRepository repository;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${sp.rabbitmq.queue}")
    public void recievedMessage(Customer customer) {
        repository.save(customer);
        System.out.println("Recieved Message From RabbitMQ: " + customer.toString());
    }
}

