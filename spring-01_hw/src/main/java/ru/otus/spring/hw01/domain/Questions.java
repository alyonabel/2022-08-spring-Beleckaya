package ru.otus.spring.hw01.domain;


public class Questions {

    private final String fileName;

    public Questions(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return fileName;
    }

}
