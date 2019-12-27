package ru.otus.homework.dao.ext;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookResultSetExtractor implements ResultSetExtractor<List<Book>> {
    @Override
    public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            Book book = new Book(id,
                    resultSet.getString("title"));
            book.setAuthor(new Author(resultSet.getLong("authorId"), resultSet.getString("authorName")));
            book.setGenre(new Genre(resultSet.getLong("genreId"), resultSet.getString("genreName")));
            books.add(book);
        }
        return books;
    }
}
