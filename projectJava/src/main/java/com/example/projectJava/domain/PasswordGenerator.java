package com.example.projectJava.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class PasswordGenerator {
    private List<String> wordList;
    private Random random;

    public PasswordGenerator(List<String> wordList) {
        this.wordList = wordList;
        random = new Random();
    }

    public String generatePassword(int length) {
        System.out.println("Word list size: " + wordList.size());

        List<String> filteredWords = wordList.stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toList());

        if (filteredWords.isEmpty()) {
            System.out.println("No words with the specified length found.");
            return "";
        }

        String randomWord = filteredWords.get(random.nextInt(filteredWords.size()));
        System.out.println("Generated word: " + randomWord);
        return randomWord;
    }
}
