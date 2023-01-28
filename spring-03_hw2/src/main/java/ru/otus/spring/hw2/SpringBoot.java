package ru.otus.spring.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.spring.hw2.config.ApplicationProps;
import ru.otus.spring.hw2.service.QuestionService;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProps.class)
public class SpringBoot {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(SpringBoot.class, args);
        QuestionService service = context.getBean(QuestionService.class);
        service.startTest();
        context.close();
           }
}