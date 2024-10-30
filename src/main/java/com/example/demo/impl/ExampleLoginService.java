package com.example.demo.impl;

import com.example.demo.services.LoginService;

public class ExampleLoginService implements LoginService{

    private String realLogin;
    private String realPass;

    public ExampleLoginService(String realLogin, String realPass) {
        this.realPass = realPass;
        this.realLogin = realLogin;
    }

    @Override
    public Integer login(String username, String password) {
        if (!username.equals(realLogin)) {
            return -1;

        }

        if (!password.equals(realPass)) {
            return -1;
        }

        return 1;

    }
    
}
