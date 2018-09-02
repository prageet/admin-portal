package com.prageet.adminportal.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository repository;
	
	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}

	@Override
	public Category delete(int id) {
		// TODO Auto-generated method stub
		Category category = findById(id);
        if(category != null){
            repository.delete(category);
        }
        return category;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}

}
