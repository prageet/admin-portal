package com.prageet.adminportal.user;

import java.util.List;

public interface UserService {

    ApplicationUser create(ApplicationUser user);

    ApplicationUser delete(int id);

    List<ApplicationUser> findAll();

    ApplicationUser findById(int id);
    
    ApplicationUser update(ApplicationUser user);
}
