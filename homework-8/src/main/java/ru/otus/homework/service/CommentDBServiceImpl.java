package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repo.CommentRepo;

@Service
@Qualifier("commentDBService")
public class CommentDBServiceImpl implements CommentDBService {
    private final SequenceGeneratorService sequenceGeneratorService;
    private final CommentRepo commentRepo;

    public CommentDBServiceImpl(SequenceGeneratorService sequenceGeneratorService, CommentRepo commentRepo) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.commentRepo = commentRepo;
    }

    @Override
    public void delete(Comment comment) {
        commentRepo.delete(comment);
    }

    @Override
    public void save(Comment comment) {
        comment.setId(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
        commentRepo.save(comment);
    }
}
