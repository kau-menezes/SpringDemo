package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.backendchallanges.Collatz;
import com.example.demo.dto.backendchallanges.ImaExp;

import java.util.*;

// um único controlador com baseurl
@RestController
@CrossOrigin(origins = {"http://localhost:5257"})
public class BackEndChallanges {
    

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

    @GetMapping("/imaexp")
    public ImaExp imaginaryExponential(Double A, Double b) {
        
        Double im = Math.pow(A, Math.cos(b));
        Double re = Math.pow(A, Math.sin(b));
        
        return new ImaExp(re, im);
    }

    // @PostMapping("/collatz")
    // public ResponseEntity<CollatzRes> collatzConjecure(@RequestBody Collatz nums) {

    //     if (nums.step() < 0 || nums.current() < 0) {
    //         return ResponseEntity.status(400).build();
    //     }

    //     Long new_current = 0l;

    //     if (nums.current() % 2 == 0 ) {

    //         for (int i = 0; i < nums.step(); i++) {
    //             new_current = nums.current() / 2;
    //         }

    //     } else {
    //         for (int i = 0; i < nums.step(); i++) {
    //             new_current = 3 * nums.current() - 1; 
    //         }
    //     }

    //     return ResponseEntity.ok(new CollatzRes(new_current));
    // }

    @GetMapping("/collatz")
    public ResponseEntity<Collatz> collatzConjecure(Integer step, Integer current) {

        if (step < 0 || current < 0) {
            return ResponseEntity.status(400).build();
        }

        Integer new_current = current;

        for (int i = 0; i < step; i++) {
            if (current % 2 == 0 ) {
                new_current = new_current / 2;
                
            } else {
                new_current = 3 * new_current - 1; 
            }

            System.out.println(new_current);
        }

        return ResponseEntity.ok(new Collatz(new_current));
    }

    // @GetMapping("/curitiba")
    // public CuritibaRes curitiba(String cep, String cpf) throws Exception {
        // ArrayList<String> resultArray = new ArrayList<>();
        // HttpRequest requestCep = HttpRequest.newBuilder()
        //         .uri(new URI("https://viacep.com.br/ws/" + cep + "/json/"))
        //         .GET()
        //         .build();
        // // HttpResponse<Curitiba> response = HttpClient.newHttpClient()
        //         // .send(request, HttpResponse.BodyHandlers.ofString());
        // HttpResponse<String> responseCep = HttpClient.newHttpClient()
        // .send(requestCep, HttpResponse.BodyHandlers.ofString());
        // System.out.println("Request: " + requestCep.toString());
        // System.out.println("Response: " + responseCep.body());
        // if (responseCep.body().localidade() != "pr") {
        //     resultArray.add(new String("it is not curitibinha"));
        // }
        // Integer cpfSum = 0;
        // for (int i = 0; i < cpf.length(); i++ ) {
        //     cpfSum = cpfSum + cpf.charAt(i);
        // }
        //:(
        // return new CuritibaRes(resultArray);
    // }



}
