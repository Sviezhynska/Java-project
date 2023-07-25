import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private List<String> wordList;
    private Random random;

    public PasswordGenerator() {
        wordList = new ArrayList<>();
        random = new Random();
    }

    public void addWord(String word) {
        wordList.add(word);
    }

    public String generatePassword(int length) {
        if (wordList.isEmpty()) {
            System.out.println("Word list is empty");
            return "";
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String randomWord = wordList.get(random.nextInt(wordList.size()));
            password.append(randomWord);
        }

        return password.toString();
    }
}
