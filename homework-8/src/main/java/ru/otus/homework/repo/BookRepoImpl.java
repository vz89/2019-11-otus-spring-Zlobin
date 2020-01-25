package ru.otus.homework.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

public class BookRepoImpl implements BookRepoCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount() {
        GroupOperation groupByAuthor = group("id","author").count().as("count");
        Aggregation aggregation = newAggregation(groupByAuthor);
        AggregationResults<AuthorBookCountAggregateResult> result = mongoTemplate.aggregate(aggregation,"book", AuthorBookCountAggregateResult.class);
        return result.getMappedResults();
    }
}
