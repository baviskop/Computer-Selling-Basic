package com.long1dep.comp_sell.service.impl;

import com.long1dep.comp_sell.entity.User;
import com.long1dep.comp_sell.repository.UserRepository;
import com.long1dep.comp_sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void createUser(User u) {
        userRepo.save(u);
    }

    @Override
    public User authenticate(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User authenticate(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }
}
