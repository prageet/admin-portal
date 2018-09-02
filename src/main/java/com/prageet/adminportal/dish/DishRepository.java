package com.prageet.adminportal.dish;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface DishRepository extends Repository<Dish, Integer> {
	
	void delete(Dish dish);

    List<Dish> findAll();

    Dish findOne(int id);

    Dish save(Dish dish);
}
