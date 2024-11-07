package com.example.demo.impl.backendchallanges;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.example.demo.dto.backendchallanges.Auth;
import com.example.demo.dto.backendchallanges.UserInfo;
import com.example.demo.services.Authentication;
import com.example.demo.services.UserService;

public class Authenticate implements Authentication{

    @Autowired
    UserService service;

    @Override
    public Auth authenticate(UserInfo user) {
        
        var status = service.login(user);

        if (status.getStatusCode() != HttpStatus.OK) {
            return new Auth("Access denied", null);
        }

        
        
        return new Auth("welcome", null);
    }
    
}
