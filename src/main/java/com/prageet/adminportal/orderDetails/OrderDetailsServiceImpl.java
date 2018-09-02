package com.prageet.adminportal.orderDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
    private OrderDetailsRepository repository;
	
	@Override
	public OrderDetails create(OrderDetails orderDetails) {
		return repository.save(orderDetails);
	}

	@Override
	public OrderDetails delete(int id) {
		OrderDetails orderDetails = findById(id);
        if(orderDetails != null){
            repository.delete(orderDetails);
        }
        return orderDetails;
	}

	@Override
	public List<OrderDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public OrderDetails findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public OrderDetails update(OrderDetails orderDetails) {
		return repository.save(orderDetails);
	}

}
