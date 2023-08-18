package com.example.projectJava.web;

import com.example.projectJava.domain.PasswordGenerator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PasswordGeneratorController {

    private final PasswordGenerator passwordGenerator;

    public PasswordGeneratorController(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @GetMapping("/generatePassword")
    public String generatePassword(@RequestParam(required = false, defaultValue = "8") int length) {
        String password = passwordGenerator.generatePassword(length);
        return "Generated Password: " + password;
    }
}
