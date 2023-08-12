package ru.otus.hw.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Genre {
    private final long id;

    @NonNull
    private final String genreName;
}
