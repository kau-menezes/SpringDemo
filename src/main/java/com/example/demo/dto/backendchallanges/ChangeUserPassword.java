package com.example.demo.dto.backendchallanges;

public record ChangeUserPassword(String username, String password, String newPassword, String repeatPassword) { }
