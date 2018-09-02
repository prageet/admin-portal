package com.prageet.adminportal.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishNameServiceImpl implements DishNameService {

	@Autowired
	private DishNameRepository dishNameRepository;
	
	@Override
	public Dish findByName(String name) {
		return dishNameRepository.findByName(name);
	}

}
