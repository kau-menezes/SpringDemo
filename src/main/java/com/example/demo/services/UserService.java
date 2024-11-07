package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.backendchallanges.ChangeUserPassword;
import com.example.demo.dto.backendchallanges.UserInfo;

public interface UserService {
    String createUser(UserInfo user);

    String changePassword(ChangeUserPassword data);

    ResponseEntity<String> login(UserInfo user);
}
