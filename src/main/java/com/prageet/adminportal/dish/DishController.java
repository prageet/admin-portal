package com.prageet.adminportal.dish;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import com.prageet.adminportal.order.Order;
import com.prageet.adminportal.orderDetails.OrderDetails;
import com.prageet.adminportal.user.ApplicationUser;
import com.prageet.adminportal.user.ApplicationUserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/dishes"})
public class DishController {
	
	@Autowired
    private DishService dishService;
	
	@Autowired
    private DishNameService dishNameService;
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;

    @PostMapping
    public Dish create(@RequestBody Dish dish) throws Exception {
    	if(dish.getName().isEmpty()) {
    		throw new CustomGenericException("500", "Dish: Dish name is required.");
    	}
    	dish.setCreationDate(getCurrentTime());
    	dish.setLastModifiedDate(getCurrentTime());
    	Dish dishResponse = dishService.create(dish);
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: Unable to create a new  dish.");
    	}
        return dishResponse;
    }

    @GetMapping(path = {"/{id}"})
    public Dish findOne(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Dish: Invalid dish id.");
    	}
    	Dish dishResponse = dishService.findById(id);
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: unable to fetch dish details.");
    	}
        return dishResponse;
    }

    @PutMapping(path = {"/{id}"})
    public Dish update(@PathVariable("id") int id, @RequestBody Dish dish) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Dish: Invalid dish id.");
    	}
    	dish.setId(id);
        dish.setLastModifiedDate(getCurrentTime());
        Dish dishResponse = dishService.update(dish);
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: Unable to update a dish.");
    	}
        return dishResponse;
    }

    @DeleteMapping(path ={"/{id}"})
    public Dish delete(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Dish: Invalid dish id.");
    	}
    	Dish dishResponse = dishService.delete(id);
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: Unable to delete a dish.");
    	}
        return dishResponse;
    }

    @GetMapping
    public List<Dish> findAll() throws Exception {
    	List<Dish> dishResponse = dishService.findAll();
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: Unable to retrieve dish list.");
    	}
        return dishResponse;
    }

    @GetMapping(path = {"search/{name}"})
    public Dish searchDishByName(@PathVariable("name") String name) throws Exception {
    	if(name.isEmpty()) {
    		throw new CustomGenericException("500", "Dish: dish name cannot be empty.");
    	}
    	Dish dishResponse = dishNameService.findByName(name);
    	if(dishResponse == null) {
    		throw new CustomGenericException("500", "Dish: unable to fetch dish details.");
    	}
        return dishResponse;
    }
    
    @GetMapping(path = {"search/ordered/recently"})
    public List<OrderDetails> recentlyOrdered() throws Exception {
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    	String userName = loggedInUser.getName();
    	System.out.println("logged in user is "+ userName);
    	ApplicationUser applicationUser = applicationUserRepository.findByEmail(userName);
    	List<Order> userOrders = applicationUser.getOrders();
    	List<OrderDetails> orderDetails = userOrders.get(userOrders.size()-1).getOrderDetails();    	
        return orderDetails;
    }
    
    public Date getCurrentTime() {
    	//Getting the current timestamp
    	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
        return timestamp;    	
    }
}
