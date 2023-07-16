package com.apache.email.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apache.domains.dto.Order;
import com.apache.domains.dto.OrderEvent;

@Service
public class EmailConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumerService.class);

	@Autowired
	private EmailSenderService senderService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		
		senderService.sendEmail("singhnaman620@gmail.com", 
				"Order Confirmation.!", 
				"Thank you for your order. We’ll send a confirmation when your order ships. "
				+ "Your estimated delivery date is indicated below. If you would like to view the status of your order "
				+ "or make any changes to it, please visit Your Orders");
	}
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Consuming Order Event in email service: %S", orderEvent.toString()));
		
		// Send an email to customer
		sendEmail();
	}
}
