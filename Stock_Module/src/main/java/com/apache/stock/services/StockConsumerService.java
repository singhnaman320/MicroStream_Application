package com.apache.stock.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apache.domains.dto.OrderEvent;

@Service
public class StockConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumerService.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Consuming Order Event from stock: %S", orderEvent.toString()));
		
		// Save the order event to the database
	}
}
