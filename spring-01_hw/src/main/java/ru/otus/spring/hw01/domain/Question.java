package ru.otus.spring.hw01.domain;


public class Question {

    private final String fileName;

    public Question(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return fileName;
    }



}
