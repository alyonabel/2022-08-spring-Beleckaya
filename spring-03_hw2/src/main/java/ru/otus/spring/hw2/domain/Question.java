package ru.otus.spring.hw2.domain;

import java.util.List;

public class Question {

    private final String fileName;
    private final List<String> question;

    public Question(String fileName, List<String> question) {

        this.fileName = fileName;
        this.question = question;
    }
}
