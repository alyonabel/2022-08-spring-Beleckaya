package ru.otus.spring.hw02.exceptions;

import java.io.IOException;

public class TestFileException extends IOException {
    public TestFileException(String s) {
        super(s);
    }
}
