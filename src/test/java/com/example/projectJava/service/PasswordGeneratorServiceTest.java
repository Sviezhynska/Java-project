import com.example.projectJava.service.PasswordGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordGeneratorServiceTest {

    @Mock
    private PasswordGeneratorService passwordGeneratorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(passwordGeneratorService.generatePassword(6)).thenReturn("password");
        when(passwordGeneratorService.generatePassword(8)).thenReturn("word");
        when(passwordGeneratorService.generatePassword(10)).thenReturn("generate");
        when(passwordGeneratorService.generatePassword(5)).thenReturn("No words with the specified length found.");
    }

    @Test
    public void testGeneratePasswordWithExistingLength() {
        assertEquals("password", passwordGeneratorService.generatePassword(6));
        assertEquals("word", passwordGeneratorService.generatePassword(8));
        assertEquals("generate", passwordGeneratorService.generatePassword(10));
    }

    @Test
    public void testGeneratePasswordWithNonExistingLength() {
        String result = passwordGeneratorService.generatePassword(5); 
        assertEquals("No words with the specified length found.", result);
    }
}
