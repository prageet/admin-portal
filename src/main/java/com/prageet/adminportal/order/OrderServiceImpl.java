package com.prageet.adminportal.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderRepository repository;

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order delete(int id) {
        Order order = findById(id);
        if(order != null){
            repository.delete(order);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }

}
