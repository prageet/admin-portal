package com.prageet.adminportal.dish;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DishNameRepository extends JpaRepository<Dish, Long> {
	Dish findByName(String name);
}
