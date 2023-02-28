package hwShell.shell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.CommandNotFound;
import org.springframework.shell.Shell;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест команд shell ")
@SpringBootTest
class ShellCommandsTest {

    @Autowired
    private Shell shell;

    private static final String GREETING_PATTERN = "Hello, I'm Spring Shell)";
    private static final String COMMAND_GREET = "greet";
    private static final String DEFAULT_GREET = "I'm Spring Shell)";


    private static final String COMMAND_NEGATIVE_TEST = "GREET";

    @Test
    void greet() {
        String result = (String) shell.evaluate(() -> COMMAND_GREET);
        assertThat(result).isEqualTo(String.format(GREETING_PATTERN, DEFAULT_GREET));
    }

    @Test
    void noCommand() {
        try {
            shell.evaluate(() -> COMMAND_NEGATIVE_TEST);
        }catch (CommandNotFound e){
            System.out.println("An exception has occurred");
        }
    }
}