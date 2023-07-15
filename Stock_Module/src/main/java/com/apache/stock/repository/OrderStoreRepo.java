package com.apache.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apache.stock.model.OrderStore;

@Repository
public interface OrderStoreRepo extends JpaRepository<OrderStore, Long>{

}
