package com.prageet.adminportal.dish;

import java.util.List;

import com.prageet.adminportal.dish.Dish;

public interface DishService {
	
	Dish create(Dish dish);

    Dish delete(int id);

    List<Dish> findAll();

    Dish findById(int id);

    Dish update(Dish dish);

}
