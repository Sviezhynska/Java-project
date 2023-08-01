import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PasswordGeneratorTest {

    private PasswordGenerator generator;

    @BeforeEach
    public void setUp() {
        generator = new PasswordGenerator();
    }

    @Test
    public void testGeneratePasswordWithEmptyWordList() {
        String password = generator.generatePassword(1);
        assertEquals("", password, "Expected an empty password when word list is empty.");
    }

    @Test
    public void testGeneratePasswordWithNonEmptyWordList() {
        List<String> words = Arrays.asList("hello", "world", "test");
        for (String word : words) {
            generator.addWord(word);
        }

        String password = generator.generatePassword(5);
        assertNotNull(password, "Password should not be null.");
        assertEquals(5, password.length(), "Password length should be 5.");
    }
}
