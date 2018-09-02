package com.prageet.adminportal.orderDetails;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface OrderDetailsRepository extends Repository<OrderDetails, Integer> {
	
	void delete(OrderDetails orderDetails);

    List<OrderDetails> findAll();

    OrderDetails findOne(int id);

    OrderDetails save(OrderDetails orderDetails);

}
