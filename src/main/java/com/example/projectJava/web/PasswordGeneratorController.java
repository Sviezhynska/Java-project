package com.example.projectJava.web;

import com.example.projectJava.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordGeneratorController {

    private final PasswordGeneratorService passwordGeneratorService;

    @Autowired
    public PasswordGeneratorController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @GetMapping("/generatePassword")
    public String generatePassword(@RequestParam(required = false, defaultValue = "8") int length) {
        String password = passwordGeneratorService.generatePassword(length);
        return "Generated Password: " + password;
    }
}
