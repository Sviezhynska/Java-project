package com.example.projectJava.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PasswordGeneratorServiceTest {

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @Test
    public void testGeneratePassword() {
        int length = 8;
        String generatedPassword = passwordGeneratorService.generatePassword(length);

        assertNotNull(generatedPassword);
        assertEquals(length, generatedPassword.length());
    }
}
