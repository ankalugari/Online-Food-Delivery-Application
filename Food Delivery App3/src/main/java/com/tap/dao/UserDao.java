package com.tap.dao;

import com.tap.model.User;

public interface UserDao {

    // Register user
    boolean registerUser(User user);

    // Login user
    User loginUser(String email, String password);

    // Get user by ID
    User getUserById(int id);
}