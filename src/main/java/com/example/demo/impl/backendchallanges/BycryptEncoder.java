package com.example.demo.impl.backendchallanges;

import com.example.demo.services.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BycryptEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}
