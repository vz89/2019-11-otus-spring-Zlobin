package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    final private IOService ioService;
    final private BookDao bookDao;
    final private  GenreService genreService;


    @Autowired
    public BookServiceImpl(IOService ioService, BookDao bookDao, GenreService genreService) {
        this.ioService = ioService;
        this.bookDao = bookDao;
        this.genreService = genreService;
    }
    public List<Book> getAll(){
        return bookDao.getAll();
    }

    @Override
    public int getCount() {
       return bookDao.getCount();
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public Book getById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public void deleteById(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book getNewBook() {
        ioService.write("Введите наименование книги");
        String title = ioService.read();
        ioService.write("Введите жанр");
        String genreName = ioService.read();
        Genre genre = genreService.getGenre(genreName);
        return new Book(title,genre);
    }




}
