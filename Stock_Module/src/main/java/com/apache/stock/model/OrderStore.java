package com.apache.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Placed_Orders")
public class OrderStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Lob
	private String stockEvent;

	public OrderStore(Long orderId, String stockEvent) {
		super();
		this.orderId = orderId;
		this.stockEvent = stockEvent;
	}

	public OrderStore() {
		super();
	}

	@Override
	public String toString() {
		return "OrderStore [orderId=" + orderId + ", stockEvent=" + stockEvent + "]";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStockEvent() {
		return stockEvent;
	}

	public void setStockEvent(String stockEvent) {
		this.stockEvent = stockEvent;
	}
}
