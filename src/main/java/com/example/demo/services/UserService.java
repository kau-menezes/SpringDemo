package com.example.demo.services;

import com.example.demo.dto.backendchallanges.ChangeUserPassword;
import com.example.demo.dto.backendchallanges.CreateUserAccount;

public interface UserService {
    String login(CreateUserAccount user);

    String changePassword(ChangeUserPassword data);
}
