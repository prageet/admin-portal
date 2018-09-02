package com.prageet.adminportal.user;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<ApplicationUser, Integer> {

    void delete(ApplicationUser user);

    List<ApplicationUser> findAll();

    ApplicationUser findOne(int id);

    ApplicationUser save(ApplicationUser user);
}
