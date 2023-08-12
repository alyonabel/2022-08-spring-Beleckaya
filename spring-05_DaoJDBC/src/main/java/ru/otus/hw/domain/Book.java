package ru.otus.hw.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {

    private final long id;

    @NonNull
    private final String name;

    @NonNull
    private String author;

    @NonNull
    private String genre;
}
