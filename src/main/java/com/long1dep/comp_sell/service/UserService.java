package com.long1dep.comp_sell.service;

import com.long1dep.comp_sell.entity.User;

public interface UserService {
    public void createUser(User u);

    public User authenticate(String email);
    public User authenticate(String email, String password);
}
