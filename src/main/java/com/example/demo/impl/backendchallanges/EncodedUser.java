package com.example.demo.impl.backendchallanges;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.backendchallanges.ChangeUserPassword;
import com.example.demo.dto.backendchallanges.UserInfo;
import com.example.demo.model.backendchallanges.UserTable;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PasswordEncoder;
import com.example.demo.services.UserService;

public class EncodedUser implements UserService{

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder encoderGuy;

    @Override
    public String createUser(UserInfo user) {
        var userEmail = userRepo.findByEmail(user.email());

        if (userEmail.size() > 0) {
            return "E-mail already registered.";
        }

        var userUsername = userRepo.findByUsername(user.username());

        if (userUsername.size() > 0) {
            return "Username already registered.";
        }

        String encodedPassword = encoderGuy.encode(user.password());

        UserTable newUser = new UserTable();
        newUser.setEmail(user.email());
        newUser.setPassword(encodedPassword);
        newUser.setUsername(user.username());

        return "User added successfuly.";

    }

    @Override
    public String changePassword(ChangeUserPassword data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }

    @Override
    public ResponseEntity<String> login(UserInfo user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}
