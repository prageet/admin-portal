package com.prageet.adminportal.categories;

import java.util.List;

public interface CategoryService {

	Category create(Category category);

	Category delete(int id);

    List<Category> findAll();

    Category findById(int id);

    Category update(Category category);
}
