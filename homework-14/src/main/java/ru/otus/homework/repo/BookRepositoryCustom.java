package ru.otus.homework.repo;

import ru.otus.homework.domain.Book;

public interface BookRepositoryCustom {
    Book findBookByCommentId(long Id);
}
