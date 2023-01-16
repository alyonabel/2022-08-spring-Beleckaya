package ru.otus.spring.hw2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProps {

    private String questionsFile;
    private String answersFile;
    private Locale locale;

    public void setQuestionsFile(String questionsFile) {
        this.questionsFile = questionsFile;
    }

    public void setAnswersFile(String answersFile) {
        this.answersFile = answersFile;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getQuestionsFile() {
        return questionsFile;
    }

    public String getAnswersFile() {
        return answersFile;
    }

    public Locale getLocale() {
        return locale;
    }


}
