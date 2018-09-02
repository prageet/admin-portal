package com.prageet.adminportal.orderDetails;

import java.util.List;

public interface OrderDetailsService {
	
	OrderDetails create(OrderDetails orderDetails);

    OrderDetails delete(int id);

    List<OrderDetails> findAll();

    OrderDetails findById(int id);

    OrderDetails update(OrderDetails orderDetails);

}
