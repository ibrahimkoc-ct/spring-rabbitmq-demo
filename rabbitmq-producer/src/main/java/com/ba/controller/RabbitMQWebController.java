package com.ba.controller;

import com.ba.model.Customer;
import com.ba.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class RabbitMQWebController {

	@Autowired
	RabbitMQService service;

	@PostMapping()
	public ResponseEntity<String> producer(@RequestBody Customer customer) {
		service.send(customer);

		return ResponseEntity.ok(customer.toString());
	}

}

