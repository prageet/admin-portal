package com.prageet.adminportal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public ApplicationUser create(ApplicationUser user) {
        return repository.save(user);
    }

    @Override
    public ApplicationUser delete(int id) {
        ApplicationUser user = findById(id);
        if(user != null){
            repository.delete(user);
        }
        return user;
    }

    @Override
    public List<ApplicationUser> findAll() {
        return repository.findAll();
    }

    @Override
    public ApplicationUser findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public ApplicationUser update(ApplicationUser user) {
        return repository.save(user);
    }
}
