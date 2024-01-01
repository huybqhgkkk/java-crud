package com.spring.mongo.demo.service;

import com.spring.mongo.demo.model.User;

public interface AuthService {

    boolean usernameExists(String username);

    void registerUser(User user);

    // Các phương thức khác liên quan đến xác thực người dùng nếu cần thiết
}
