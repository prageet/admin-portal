package com.prageet.adminportal.categories;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, Integer> {

    void delete(Category category);

    List<Category> findAll();

    Category findOne(int id);

    Category save(Category category);
}
