package com.prageet.adminportal.order;

import java.util.List;

public interface OrderService {
	
	Order create(Order order);

    Order delete(int id);

    List<Order> findAll();

    Order findById(int id);

    Order update(Order order);

}
