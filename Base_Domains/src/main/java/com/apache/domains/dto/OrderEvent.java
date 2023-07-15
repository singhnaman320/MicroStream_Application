package com.apache.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This is the entity we will use to transfer the data between producer and consumer using Apache Kafka

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

	private String message;
	private String status;
	private Order order;
	
}
