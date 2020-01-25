package ru.otus.homework.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.homework.domain.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookCountAggregateResult {
    private Author author;
    private int count;

    @Override
    public String toString() {
        return
                "author=" + author +
                        ", count=" + count;
    }
}
