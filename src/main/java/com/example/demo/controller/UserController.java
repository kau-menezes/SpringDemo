package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginData;

@RestController
@RequestMapping("/user")
public class UserController {

    // o body da requisição deve seguir o padrão de escrita dos astributos criados na classe/ record 
    @PostMapping
    public ResponseEntity login(@RequestBody LoginData data) {
        if (data.Login().equals("don") && data.Password().equals("ferrari"))
            return ResponseEntity.ok("bem-vindo!");

        return ResponseEntity.status(404).build();
        
    }
}
