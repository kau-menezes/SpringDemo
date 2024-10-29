package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SumResult;

@RestController
@RequestMapping("/test") // base url para o controller inteiro
public class TestControllerJava {
    
    @GetMapping("/div")
    public Integer test(Integer a, Integer b) {
        return a / b; // http://localhost:8080/test/div?a=95&b=5
    }

    // usar PathVariable quando o valor for indispensável, e usar query params quando for opcional 
    @GetMapping("/{a}")
    public SumResult test2(@PathVariable Integer a, Integer b) {
        if (b == null) // http://localhost:8080/test/95?b=5
            b = 2;
        var oi =  a + b;
        var isEven = oi % 2 == 0;

        return new SumResult(oi, isEven);
    }
}
