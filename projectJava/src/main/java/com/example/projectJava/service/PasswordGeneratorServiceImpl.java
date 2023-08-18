package com.example.projectJava.service;
import com.example.projectJava.domain.PasswordGenerator;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private final PasswordGenerator passwordGenerator;

    public PasswordGeneratorServiceImpl(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Override
    public String generatePassword(int length) {
        return passwordGenerator.generatePassword(length);
    }
}
