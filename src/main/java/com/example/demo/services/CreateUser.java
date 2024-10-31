package com.example.demo.services;

import com.example.demo.model.backendchallanges.UserTable;

public interface CreateUser {
    UserTable login(String username, String password);
}
