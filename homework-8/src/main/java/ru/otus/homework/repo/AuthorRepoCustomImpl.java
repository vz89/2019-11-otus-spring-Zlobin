package ru.otus.homework.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.homework.domain.Author;
import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@RequiredArgsConstructor
public class AuthorRepoCustomImpl implements AuthorRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public void deleteBookById(long id) {
        Query query = Query.query(Criteria.where("$id").is(id));
        Update update = new Update().pull("books",query);
        mongoTemplate.updateMulti(new Query(),update, Author.class);
    }
    @Override
    public List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount() {
        GroupOperation groupByAuthor = group("id","author").count().as("count");
        Aggregation aggregation = newAggregation(groupByAuthor);
        AggregationResults<AuthorBookCountAggregateResult> result = mongoTemplate.aggregate(aggregation,"book", AuthorBookCountAggregateResult.class);
        return result.getMappedResults();
    }
}
