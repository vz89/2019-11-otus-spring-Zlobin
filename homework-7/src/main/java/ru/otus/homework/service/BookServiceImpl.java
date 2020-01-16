package ru.otus.homework.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repo.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    final private IOService ioService;
    final private GenreService genreService;
    final private AuthorService authorService;
    final private BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(IOService ioService, GenreService genreService, AuthorService authorService, BookRepository bookRepository) {
        this.ioService = ioService;
        this.bookRepository = bookRepository;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findBooksByTitle(name);
    }

    @Transactional
    @Override
    public void updateNameById(long id, String name) {
        bookRepository.updateNameById(id, name);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addNewBook() {
        ioService.write("Введите наименование книги");
        String title = ioService.read();
        ioService.write("Введите жанр");
        String genreName = ioService.read();
        ioService.write("Введите автора");
        String authorName = ioService.read();
        Author author = authorService.findByName(authorName);
        if (author == null) author = new Author(authorName);
        Genre genre = genreService.findByName(genreName);
        if (genre == null) genre = new Genre(genreName);
        Book book = new Book(title, author, genre);
        bookRepository.save(book);
    }

    @Override
    public long getCount() {
        return bookRepository.count();
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        return bookRepository.findBooksByAuthor_Id(id);
    }


    @Override
    public Map<Book, Long> findAllBooksWithCommentsCount() {
        List<ImmutablePair<Book, Long>> pairList= bookRepository.findAllBooksWithCommentsCount();
        Map<Book,Long> bookMap = new HashMap<>();
        for (ImmutablePair pair: pairList)
            bookMap.put((Book)pair.left,(long)pair.right);
        return bookMap;
    }

}