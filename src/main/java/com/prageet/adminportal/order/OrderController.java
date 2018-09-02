package com.prageet.adminportal.order;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prageet.adminportal.CustomGenericException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/orders"})
public class OrderController {
	
	@Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order) throws Exception {
    	order.setCreationDate(getCurrentTime());
    	order.setLastModifiedDate(getCurrentTime());
    	Order orderResponse = orderService.create(order);
    	if(orderResponse == null) {
    		throw new CustomGenericException("500", "Order: Unable to generate order.");
    	}
        return orderResponse;
    }

    @GetMapping(path = {"/{id}"})
    public Order findOne(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Order: Invalid order id.");
    	}
    	Order orderResponse = orderService.findById(id);
    	if(orderResponse == null) {
    		throw new CustomGenericException("500", "Order: Unable to retrieve requested order details.");
    	}
        return orderResponse;
    }

    @PutMapping(path = {"/{id}"})
    public Order update(@PathVariable("id") int id, @RequestBody Order order) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Order: Invalid order id.");
    	}
    	order.setId(id);
        order.setLastModifiedDate(getCurrentTime());
        Order orderResponse = orderService.update(order);
    	if(orderResponse == null) {
    		throw new CustomGenericException("500", "Order: Unable to update an order.");
    	}
        return orderResponse;
    }

    @DeleteMapping(path ={"/{id}"})
    public Order delete(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Order: Invalid order id.");
    	}
    	Order orderResponse = orderService.delete(id);
    	if(orderResponse == null) {
    		throw new CustomGenericException("500", "Order: Unable to delete an order.");
    	}
        return orderResponse;
    }

    @GetMapping
    public List<Order> findAll() throws Exception {
    	List<Order> orderResponseList = orderService.findAll();
    	if(orderResponseList.isEmpty()) {
    		throw new CustomGenericException("500", "Order: Unable to fetch an order list.");
    	}
        return orderResponseList;
    }
    
    public Date getCurrentTime() {
    	//Getting the current timestamp
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
        return timestamp;    	
    }
}
