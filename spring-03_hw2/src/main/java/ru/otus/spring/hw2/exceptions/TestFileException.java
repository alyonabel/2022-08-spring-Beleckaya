package ru.otus.spring.hw2.exceptions;

import java.io.IOException;

public class TestFileException extends IOException {
    public TestFileException(String s) {
        super(s);
    }
}
