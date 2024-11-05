package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.backendchallanges.ChangeUserPassword;
import com.example.demo.dto.backendchallanges.Cities;
import com.example.demo.dto.backendchallanges.Collatz;
import com.example.demo.dto.backendchallanges.CreateUserAccount;
import com.example.demo.dto.backendchallanges.CuritibaRes;
import com.example.demo.dto.backendchallanges.ImaExp;
import com.example.demo.repositories.CityRepository;
import com.example.demo.services.UserService;

import java.util.*;

// um único controlador com baseurl
@RestController
@CrossOrigin(origins = { "http://localhost:5257" })
public class BackEndChallanges {

    // repository do C5
    @Autowired
    CityRepository cityRepo;

    @Autowired
    UserService createUserService;

    /* ----------------------------------- C1 ----------------------------------- */

    @GetMapping("/reverse/{string}")
    public ArrayList<String> palindromeCheck(@PathVariable String string) {
        ArrayList<String> result = new ArrayList<>();

        String reverse = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }

        result.add(reverse);

        System.out.println(string + " - " + reverse);

        if (string.equals(reverse)) {
            result.add("true");
        } else {
            result.add("false");
        }

        return result;

    }

    /* ----------------------------------- C2 ----------------------------------- */

    @GetMapping("/imaexp")
    public ImaExp imaginaryExponential(Double A, Double b) {

        Double im = Math.pow(A, Math.cos(b));
        Double re = Math.pow(A, Math.sin(b));

        return new ImaExp(re, im);
    }

    /* ----------------------------------- C3 ----------------------------------- */

    @GetMapping("/collatz")
    public ResponseEntity<Collatz> collatzConjecure(Integer step, Integer current) {

        if (step < 0 || current < 0) {
            return ResponseEntity.status(400).build();
        }

        Integer new_current = current;

        for (int i = 0; i < step; i++) {
            if (current % 2 == 0) {
                new_current = new_current / 2;

            } else {
                new_current = 3 * new_current - 1;
            }

            System.out.println(new_current);
        }

        return ResponseEntity.ok(new Collatz(new_current));
    }

    /* ----------------------------------- C4 ----------------------------------- */

    @GetMapping("/curitiba")
    public CuritibaRes curitiba(String cep, String cpf) throws Exception {

        ArrayList<String> resultArray = new ArrayList<>();

        resultArray.add(new String("Unknown location for CEP " + cep));

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            resultArray.add(new String("CPF doesn't have 11 characters"));
            return new CuritibaRes(resultArray);
        }

        for (int i = 0; i < 2; i++) {
            int soma = 0;
            int peso = 10 + i;

            for (int j = 0; j < peso - 1; j++) {
                soma += Character.getNumericValue(cpf.charAt(j)) * peso--;
            }

            int dv = soma % 11 < 2 ? 0 : 11 - (soma % 11);
            if (Character.getNumericValue(cpf.charAt(peso - 1)) != dv) {
                resultArray.add(new String("Verifying digit does not match for the CPF informed."));
                return new CuritibaRes(resultArray);
            }
        }

        resultArray.add(new String("CPF is valid. congrats."));

        return new CuritibaRes(resultArray);
    }

    /* ----------------------------------- C5 ----------------------------------- */

    @GetMapping("/cities")
    public Cities getCities() {
        var cities = cityRepo.findAll();
        return new Cities(cities);

    }

    @GetMapping("/cities/{country}")
    public Cities getCitiesByName(@PathVariable String country) {
        var cities = cityRepo.findByCountry(country);
        return new Cities(cities);

    }

    /* ----------------------------------- C6 ----------------------------------- */

    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserAccount user) {

        return createUserService.login(user);
    }

    /* ----------------------------------- C7 ----------------------------------- */
    @PatchMapping("/changepassword")

    public String updatePasswordUser(@RequestBody ChangeUserPassword user) {
        return createUserService.changePassword(user);
    }
}
