package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.domain.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    final private IOService ioService;
    final private BookDao bookDao;


    @Autowired
    public BookServiceImpl(IOService ioService, BookDao bookDao) {
        this.ioService = ioService;
        this.bookDao = bookDao;
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
        long id = ioService.readInt();
        String title = ioService.read();
        return new Book(id,title);
    }

    ;


}
