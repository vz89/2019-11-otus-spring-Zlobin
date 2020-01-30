package ru.otus.homework.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import ru.otus.homework.dto.AuthorBookCountAggregateResult;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@RequiredArgsConstructor
public class AuthorRepoCustomImpl implements AuthorRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount() {
        GroupOperation groupByAuthor = group("id","author").count().as("count");
        Aggregation aggregation = newAggregation(groupByAuthor);
        AggregationResults<AuthorBookCountAggregateResult> result = mongoTemplate.aggregate(aggregation,"book", AuthorBookCountAggregateResult.class);
        return result.getMappedResults();
    }
}
