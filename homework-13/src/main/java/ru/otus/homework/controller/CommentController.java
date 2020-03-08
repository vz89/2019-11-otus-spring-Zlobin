package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.User;
import ru.otus.homework.service.CommentService;
import ru.otus.homework.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;

    @PreAuthorize("hasAuthority('ADMIN') or principal.username == #comment.user.username")
    @PostMapping("/delete/{comment}")
    public String deleteComment(@PathVariable Comment comment) {
        long id = comment.getBook().getId();
        commentService.deleteComment(comment);
        return "redirect:/view/" + id;
    }

    @GetMapping(value = "/addcomment", params = "bookId")
    public String addComment(@RequestParam("bookId") Book book,
                             Model model, Principal principal) {
        model.addAttribute("comment", new Comment("", book, (User) userService.loadUserByUsername(principal.getName())));
        return "editComment";
    }


    @PostMapping("/addcomment")
    public String addBook(@ModelAttribute Comment comment) {
        commentService.addOrSaveComment(comment);
        return "redirect:/view/" + comment.getBook().getId();
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.username == #comment.user.username")
    @GetMapping("/edit/{comment}")
    public String editComment(@PathVariable Comment comment, Model model) {
        model.addAttribute("comment", comment);
        return "editComment";
    }

}
