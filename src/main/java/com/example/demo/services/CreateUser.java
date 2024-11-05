package com.example.demo.services;

import com.example.demo.dto.backendchallanges.CreateUserAccount;

public interface CreateUser {
    String login(CreateUserAccount user);
}
