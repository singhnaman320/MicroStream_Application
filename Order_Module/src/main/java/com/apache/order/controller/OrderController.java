package com.apache.order.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache.domains.dto.Order;
import com.apache.domains.dto.OrderEvent;
import com.apache.order.services.OrderProducerService;

@RestController
@RequestMapping("/api/v2")
public class OrderController {

	private OrderProducerService orderProducerService;

	public OrderController(OrderProducerService orderProducerService) {
		super();
		this.orderProducerService = orderProducerService;
	}
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("Order Pending");
		orderEvent.setMessage("Please confirm your order.!");
		orderEvent.setOrder(order);
		
		orderProducerService.sendMessage(orderEvent);
		
		return "Order Placed Successfully.!";
	}
}
