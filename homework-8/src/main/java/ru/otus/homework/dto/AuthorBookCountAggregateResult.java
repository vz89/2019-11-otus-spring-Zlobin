package ru.otus.homework.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBookCountAggregateResult that = (AuthorBookCountAggregateResult) o;
        return count == that.count &&
                author.equals(that.author);
    }


}
