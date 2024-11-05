package com.example.demo.impl.backendchallanges;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.backendchallanges.ChangeUserPassword;
import com.example.demo.dto.backendchallanges.CreateUserAccount;
import com.example.demo.model.backendchallanges.UserTable;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

public class UserImplementation implements UserService {

    // repository do C6
    @Autowired
    UserRepository userRepo;

    public Boolean verifyPasswordLenght(String password) {
        return password.length() >= 8;
    }

    public Boolean verifyPasswordUpperCaseLetters(String password) {
        boolean upper = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                upper = true;
                break;
            }
        }

        return upper;
    }

    public Boolean verifyPasswordLowerCaseLetters(String password) {
        boolean lower = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                lower = true;
                break;
            }

        }

        return lower;
    }

    public Boolean verifyPasswordNumbers(String password) {
        boolean nums = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                nums = true;
                break;
            }
        }

        return nums;
        
    }

    public Boolean verifyOverallPassword(String password) {
        
        Boolean psLength = verifyPasswordLenght(password);

        Boolean psUpper = verifyPasswordUpperCaseLetters(password);

        Boolean psLower = verifyPasswordLowerCaseLetters(password);

        Boolean psNums = verifyPasswordNumbers(password);

        return psLength && psUpper && psLower && psNums;
    }

    @Override
    public String login(CreateUserAccount user) {
        var cities = userRepo.findByEmail(user.email());

        if (cities.size() > 0) {
            return "E-mail already registered.";
        }

        Boolean psLength = verifyPasswordLenght(user.password());

        if (!psLength)
            return "Password must be at least 8 characters long.";

        Boolean psUpper = verifyPasswordUpperCaseLetters(user.password());

        if (!psUpper)
            return "Password must have at least one (1) upper case letter.";

        Boolean psLower = verifyPasswordLowerCaseLetters(user.password());

        if (!psLower)
            return "Password must have at least one (1) lower case letter.";


        Boolean psNums = verifyPasswordNumbers(user.password());

        if (!psNums)
            return "Password must have at elast one (1) number.";
        
        UserTable newUser = new UserTable();
        newUser.setEmail(user.email());
        newUser.setPassword(user.password());
        newUser.setUsername(user.username());

        userRepo.saveAndFlush(newUser);

        return "User added to database succesfully." ;
    }

    @Override
    public String changePassword(ChangeUserPassword data) {
        
        UserTable user = userRepo.findByUsername(data.username()).get(0);

        if (user == null) {
            return "User not found.";
        }

        Boolean ps = verifyOverallPassword(data.newPassword());

        if (!ps) {
            return "New password is not valid. Please check all requisites.";
        }

        if (!data.newPassword().equals(data.repeatPassword())) {
            return "The passwords do not match.";
        }

        user.setPassword(data.newPassword());

        userRepo.save(user);

        return "Password updated with success.";

    }

    
}
