package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookCount {
    private Author author;
    private int count;

    @Override
    public String toString() {
        return
                "author=" + author +
                        ", count=" + count;
    }
}
