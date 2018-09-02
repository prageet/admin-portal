package com.prageet.adminportal.orderDetails;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/orderDetails"})
public class OrderDetailsController {
	
	@Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public OrderDetails create(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.create(orderDetails);
    }

    @GetMapping(path = {"/{id}"})
    public OrderDetails findOne(@PathVariable("id") int id){
        return orderDetailsService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public OrderDetails update(@PathVariable("id") int id, @RequestBody OrderDetails orderDetails){
        orderDetails.setId(id);
        return orderDetailsService.update(orderDetails);
    }

    @DeleteMapping(path ={"/{id}"})
    public OrderDetails delete(@PathVariable("id") int id) {
        return orderDetailsService.delete(id);
    }

    @GetMapping
    public List<OrderDetails> findAll(){
        return orderDetailsService.findAll();
    }
}
