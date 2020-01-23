package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.repo.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public void deleteById(long id) {
        commentRepo.deleteById(id);
    }
}
