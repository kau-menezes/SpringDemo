// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.dto.LoginData;
// import com.example.demo.services.LoginService;

// @RestController
// @RequestMapping("/user")
// public class UserController {

//     // o body da requisição deve seguir o padrão de escrita dos astributos criados na classe/ record 
//     @Autowired
//     LoginService service;

//     @PostMapping
//     public ResponseEntity<String> login(@RequestBody LoginData data) {
//         var id = service.login(data.Login(), data.Password());

//         if (id == 1 ) {
//             return ResponseEntity.ok("bem vindo amg");
//         } else {
//             return ResponseEntity.status(403).build();

//         }
        
//     }
// }
