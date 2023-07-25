import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        loadWordsFromFile(generator, "words-password.txt");

        String password = generator.generatePassword(1);
        System.out.println("Password: " + password);
    }

    public static void loadWordsFromFile(PasswordGenerator generator, String fileName) {
        try (InputStream inputStream = Main.class.getResourceAsStream("/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generator.addWord(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}
