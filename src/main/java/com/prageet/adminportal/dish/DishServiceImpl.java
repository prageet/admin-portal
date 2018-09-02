package com.prageet.adminportal.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
    private DishRepository repository;

    @Override
    public Dish create(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish delete(int id) {
        Dish dish = findById(id);
        if(dish != null){
            repository.delete(dish);
        }
        return dish;
    }

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Dish findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Dish update(Dish dish) {
        return repository.save(dish);
    }

}
