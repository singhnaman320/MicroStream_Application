package com.apache.stock.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apache.domains.dto.OrderEvent;
import com.apache.stock.model.OrderStore;
import com.apache.stock.repository.OrderStoreRepo;

@Service
public class StockConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumerService.class);
	
	@Autowired
	private OrderStoreRepo orderStoreRepo;
	
	
	public StockConsumerService(OrderStoreRepo orderStoreRepo) {
		super();
		this.orderStoreRepo = orderStoreRepo;
	}


	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Consuming Order Event from stock: %S", orderEvent.toString()));
		
		// Save the order event to the database
		
		OrderStore orderStore = new OrderStore();
		orderStore.setStockEvent(orderEvent.toString());
		
		orderStoreRepo.save(orderStore); // Orders which are placed are stored into database
		
		System.out.println("Order details saved into database successfully.!");
			
	}
}
