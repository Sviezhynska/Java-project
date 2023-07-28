import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = initializeGenerator();
        if (generator == null) {
            System.out.println("Password generation failed. Exiting.");
            return;
        }

        int passwordLength;
        while (true) {
            passwordLength = readPasswordLengthFromUser();
            if (passwordLength >= 6 && passwordLength <= 10) {
                break;
            }
            System.out.println("Invalid password length. Please enter a number between 6 and 10.");
        }

        String password = generator.generatePassword(passwordLength);
        if (!password.isEmpty()) {
            System.out.println("Generated Password: " + password);
        }
    }

    public static PasswordGenerator initializeGenerator() {
        List<String> wordList = new ArrayList<>();
        try (InputStream inputStream = Main.class.getResourceAsStream("/words-password.txt");
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                wordList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            return null;
        }

        return new PasswordGenerator(wordList);
    }

    public static int readPasswordLengthFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired password length (6-10): ");
        return scanner.nextInt();
    }
}
