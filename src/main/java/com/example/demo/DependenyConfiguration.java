package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.impl.UserImplementation;
import com.example.demo.impl.ExampleLoginService;
import com.example.demo.services.UserService;
import com.example.demo.services.LoginService;

@Configuration
public class DependenyConfiguration {
    
    @Bean
    @Scope("singleton") // prototype:   cria um obj novo a cada requisição 
                        // request:     existe durante a requisição, caso precise de um mesmo obj ele reutiliza na requisição
                        // sessio:      cria um obejto para cada usuário

                        // serviço User e serviço Product dependem de um serviço database (Context por exemplo), use o request

    public LoginService loginService() {
        return new ExampleLoginService("don", "ferrari");
    }

    @Bean
    public UserService createUserService() {
        return new UserImplementation();
    }
}
