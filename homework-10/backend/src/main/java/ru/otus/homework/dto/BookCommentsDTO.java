package ru.otus.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

@AllArgsConstructor
@Data
public class BookCommentsDTO {
    Book book;
    List<Comment> comments;

}
