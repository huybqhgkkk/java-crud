package com.spring.mongo.demo.service;

import com.spring.mongo.demo.model.User;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
}