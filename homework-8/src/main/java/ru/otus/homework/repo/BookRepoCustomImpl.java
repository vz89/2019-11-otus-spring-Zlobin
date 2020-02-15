package ru.otus.homework.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.homework.domain.Book;

@RequiredArgsConstructor
public class BookRepoCustomImpl implements BookRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public void deleteCommentById(long id) {
        Query query = Query.query(Criteria.where("$id").is(id));
        Update update = new Update().pull("comments",query);
        mongoTemplate.updateMulti(new Query(),update, Book.class);
    }


}
