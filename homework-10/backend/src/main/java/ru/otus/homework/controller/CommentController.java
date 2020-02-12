package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        commentService.addOrSaveComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
