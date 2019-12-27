package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.dao.AuthorDao;
import ru.otus.homework.domain.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
    final private AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getById(long id) {
        return authorDao.getById(id);
    }

    @Override
    public Author getAuthor(String authorName) {
        if (!checkAuthorInBase(authorName)) authorDao.insert(new Author(authorName));
        return authorDao.getByName(authorName);
    }

    private boolean checkAuthorInBase(String authorName){
        return authorDao.checkByName(authorName);
    }
}
