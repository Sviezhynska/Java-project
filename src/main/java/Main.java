package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        loadWordsFromFile(generator, "words-password.txt");

        String password = generator.generatePassword(1);
        System.out.println("Password: " + password);
    }

    public static void loadWordsFromFile(PasswordGenerator generator, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generator.addWord(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}
