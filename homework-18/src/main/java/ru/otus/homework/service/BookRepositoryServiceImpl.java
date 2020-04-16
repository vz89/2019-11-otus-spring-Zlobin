package ru.otus.homework.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repo.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookRepositoryServiceImpl implements BookRepositoryService {
    private final BookRepository bookRepository;
    private final CachedDataService cachedDataService;

    @HystrixCommand(fallbackMethod = "getCachedBooks")
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();

    }

    @HystrixCommand(fallbackMethod = "getCachedBookById")
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    private List<Book> getCachedBooks() {
        return cachedDataService.getCachedBooks();
    }

    private Book getCachedBookById(Long id) {
        return cachedDataService.getCachedBook();
    }
}
