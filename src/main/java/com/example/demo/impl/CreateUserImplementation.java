package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.backendchallanges.CreateUserAccount;
import com.example.demo.model.backendchallanges.UserTable;
import com.example.demo.repositories.CreateUserRepository;
import com.example.demo.services.CreateUser;

public class CreateUserImplementation implements CreateUser {

        // repository do C6
    @Autowired
    CreateUserRepository userRepo;

    @Override
    public String login(CreateUserAccount user) {
        var cities = userRepo.findByEmail(user.email());

        if (cities.size() > 0) {
            return "E-mail already registered.";
        }

        if (user.password().length() < 8) {
            return "Password must be at least 8 characters long.";

        }

        boolean upper = false;
        boolean lower = false;
        boolean num = false;

        for (int i = 0; i < user.password().length(); i++) {
            if (user.password().charAt(i) >= 65 && user.password().charAt(i) <= 90) {
                upper = true;
                break;
            }
        }

        if (!upper)
            return "Password must contain uppercase letters.";


        for (int i = 0; i < user.password().length(); i++) {
            if (user.password().charAt(i) >= 97 && user.password().charAt(i) <= 122) {
                lower = true;
                break;
            }

        }

        if (!lower)
            return "Password must contain lowercase letters.";

        for (int i = 0; i < user.password().length(); i++) {
            if (user.password().charAt(i) >= 48 && user.password().charAt(i) <= 57) {
                num = true;
                break;
            }
        }
        
        if (!num)
            return "Password must contain numbers.";

        
        UserTable newUser = new UserTable();
        newUser.setEmail(user.email());
        newUser.setPassword(user.password());
        newUser.setUsername(user.username());

        userRepo.saveAndFlush(newUser);

        return "User added to database succesfully." ;
    }
    
}
