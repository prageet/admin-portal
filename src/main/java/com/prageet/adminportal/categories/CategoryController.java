package com.prageet.adminportal.categories;

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
@RequestMapping({"/categories"})
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category create(@RequestBody Category category) throws Exception {
    	if(category.getName().isEmpty()) {
    		throw new CustomGenericException("500", "Category: category name must not be empty");
    	}
    	category.setCreationDate(getCurrentTime());
    	category.setLastModifiedDate(getCurrentTime());
    	Category categoryResponse = categoryService.create(category);
    	if(categoryResponse == null) {
    		throw new CustomGenericException("500", "Category: unable to create a new category.");
    	}
        return categoryResponse;
    }
    
    @GetMapping(path = {"/{id}"})
    public Category findOne(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Category: Invalid category id.");
    	}
    	Category categoryResponse = categoryService.findById(id);
    	if(categoryResponse == null) {
    		throw new CustomGenericException("500", "Category: unable to retrieve category details.");
    	}
        return categoryResponse;
    }

    @PutMapping(path = {"/{id}"})
    public Category update(@PathVariable("id") int id, @RequestBody Category category) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Category: Invalid category id.");
    	}
    	category.setId(id);
        category.setLastModifiedDate(getCurrentTime());
        Category categoryResponse = categoryService.update(category);
    	if(categoryResponse == null) {
    		throw new CustomGenericException("500", "Category: unable to update a category.");
    	}
        return categoryResponse;
    }

    @DeleteMapping(path ={"/{id}"})
    public Category delete(@PathVariable("id") int id) throws Exception {
    	if(id < 1) {
    		throw new CustomGenericException("500", "Category: Invalid category id.");
    	}
    	Category categoryResponse = categoryService.delete(id);
    	if(categoryResponse == null) {
    		throw new CustomGenericException("500", "Category: unable to delete a category.");
    	}
        return categoryResponse;
    }

    @GetMapping
    public List<Category> findAll() throws Exception {
    	List<Category> categoryResponse = categoryService.findAll();
    	if(categoryResponse.isEmpty()) {
    		throw new CustomGenericException("500", "Category: unable to retrieve a category list.");
    	}
        return categoryResponse;
    }
    
    public Date getCurrentTime() {
    	//Getting the current timestamp
    	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
        return timestamp;    	
    }
}
