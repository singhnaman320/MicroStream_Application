package com.apache.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache.order.services.OrderProducerService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private OrderProducerService orderProducerService;

	public OrderController(OrderProducerService orderProducerService) {
		super();
		this.orderProducerService = orderProducerService;
	}
	
	
}
