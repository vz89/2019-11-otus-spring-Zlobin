package ru.otus.homework.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.homework.domain.*;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @Autowired
    MongoTemplate mongoTemplate;

    @ChangeSet(order = "001", id = "addMoreBooks", author = "vladimir")
    public void insertBooks(MongoTemplate mongoTemplate) {
        Genre genre1 = new Genre(1, "genre1");
        Genre genre2 = new Genre(2, "genre2");
        Author author1 = new Author(1, "author1");
        Author author2 = new Author(2, "author2");
        Author author3 = new Author(3, "author3");
        Comment comment1 = new Comment(1, "new comment 1");
        Comment comment2 = new Comment(2, "comment 2");
        Comment comment3 = new Comment(3, "comment 3");
        Comment comment4 = new Comment(4, "comment 4");
        List<Comment> list1 = new ArrayList();
        List<Comment> list2 = new ArrayList();
        list1.add(comment1);
        list1.add(comment2);
        list2.add(comment3);
        list2.add(comment4);

        Book book1 = new Book(1, "book1", author1, genre1, list1);
        Book book2 = new Book(2, "book2", author1, genre2, list2);
        Book book3 = new Book(3, "book3", author2, genre1, null);
        Book book4 = new Book(4, "book4", author2, genre2, null);
        Book book5 = new Book(5, "book5", author3, genre2, null);

        List<Book> author1books = new ArrayList<>();
        author1books.add(book1);
        author1books.add(book2);
        List<Book> author2books = new ArrayList<>();
        author2books.add(book3);
        author2books.add(book4);
        List<Book> author3books = new ArrayList<>();
        author3books.add(book5);

        mongoTemplate.save(genre1);
        mongoTemplate.save(genre2);
        mongoTemplate.save(author1);
        mongoTemplate.save(author2);
        mongoTemplate.save(author3);
        mongoTemplate.save(comment1);
        mongoTemplate.save(comment2);
        mongoTemplate.save(comment3);
        mongoTemplate.save(comment4);
        mongoTemplate.save(book1);
        mongoTemplate.save(book2);
        mongoTemplate.save(book3);
        mongoTemplate.save(book4);
        mongoTemplate.save(book5);


        DatabaseSequence authorsSequence = new DatabaseSequence("authors_sequence", 3);
        DatabaseSequence genresSequence = new DatabaseSequence("genres_sequence", 2);
        DatabaseSequence booksSequence = new DatabaseSequence("books_sequence", 5);
        DatabaseSequence commentSequence = new DatabaseSequence("comments_sequence", 4);

        mongoTemplate.save(authorsSequence);
        mongoTemplate.save(genresSequence);
        mongoTemplate.save(booksSequence);
        mongoTemplate.save(commentSequence);

    }
}
