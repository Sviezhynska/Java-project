package com.example.projectJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private final List<String> wordList;
    private final Random random;

    @Autowired
    public PasswordGeneratorServiceImpl() {
        this.wordList = loadWordList();
        this.random = new Random();
    }

    private List<String> loadWordList() {
        List<String> wordList = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("words-password.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            wordList = reader.lines().collect(Collectors.toList());
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return wordList;
    }

    @Override
    public String generatePassword(int length) {
        List<String> filteredWords = wordList.stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toList());

        if (filteredWords.isEmpty()) {
            return "No words with the specified length found.";
        }

        String randomWord = filteredWords.get(random.nextInt(filteredWords.size()));
        return randomWord;
    }

}
