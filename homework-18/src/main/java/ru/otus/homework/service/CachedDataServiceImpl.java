package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class CachedDataServiceImpl implements CachedDataService {

    @Override
    public List<Book> getCachedBooks() {
        List<Book> books = new ArrayList<>();
        books.add(cachedBook());
        return books;
    }

    @Override
    public Book getCachedBook() {
        return cachedBook();
    }

    @Override
    public List<Comment> getCachedComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1L,"cachedComment"));

        return comments;
    }


    private Book cachedBook(){
        Author author = new Author(1L,"cachedAuthorName");
        Genre genre = new Genre(1L,"cachedGenreName");
        return new Book(1L,"cachedBookTitle",author,genre);
    }
}
