package ru.otus.homework.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.homework.domain.Book;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Override
    public Book findBookByCommentId(long Id) {
        Query query = Query.query(Criteria.where("comments.$id").is(Id));
        return mongoTemplate.findOne(query, Book.class);
    }
}
