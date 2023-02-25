package hwShell.shell;


import hwShell.service.QuestionService;
import org.springframework.context.ApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;

@ShellComponent
public class ShellCommands {

    public QuestionService questionService;
    public ApplicationContext applicationContext;

    public ShellCommands(QuestionService questionService, ApplicationContext applicationContext) {
        this.questionService = questionService;
        this.applicationContext = applicationContext;
    }

    @ShellMethod(value = "Greetings", key = {"g", "greet"})
    public String greet(@ShellOption(defaultValue = "I'm Spring Shell)") String who) {
        return "Hello, " + who;
    }

    @ShellMethod(value = "Test", key = {"t", "test"})
    public void test() throws IOException {
        QuestionService service = applicationContext.getBean(QuestionService.class);
        service.startTest();
    }
}