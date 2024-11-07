package com.example.demo.services;

import com.example.demo.dto.backendchallanges.Auth;
import com.example.demo.dto.backendchallanges.UserInfo;

public interface Authentication {
    public Auth authenticate(UserInfo user);
}
