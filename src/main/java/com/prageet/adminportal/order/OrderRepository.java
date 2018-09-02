package com.prageet.adminportal.order;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface OrderRepository extends Repository<Order, Integer> {
	
	void delete(Order order);

    List<Order> findAll();

    Order findOne(int id);

    Order save(Order order);

}
