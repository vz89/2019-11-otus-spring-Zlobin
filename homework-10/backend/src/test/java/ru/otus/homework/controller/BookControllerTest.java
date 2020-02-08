package ru.otus.homework.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
class BookControllerTest {

    private static final String BOOK_TITLE = "booktitle";
    private static final String AUTHOR_NAME = "authorname";
    private static final String GENRE_NAME = "genrename";
    private static final int BOOK_ID = 1;

    @MockBean
    private BookService bookService;

    @MockBean
    private CommentService commentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book(BOOK_TITLE, new Author(AUTHOR_NAME), new Genre(GENRE_NAME)));
        given(bookService.findAll()).willReturn(books);
        mockMvc.perform(get("/books"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldAddNewBook() throws Exception {
        Book book = new Book(BOOK_TITLE, new Author(AUTHOR_NAME), new Genre(GENRE_NAME));
        Gson gson = new Gson();
        String json = gson.toJson(book);
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnBook() throws Exception {
        mockMvc.perform(get("/books/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldUpdateBook() throws Exception {
        Book book = new Book(BOOK_ID, BOOK_TITLE, new Author(1L, AUTHOR_NAME), new Genre(1L, GENRE_NAME));
        Gson gson = new Gson();
        String json = gson.toJson(book);
        given(bookService.update(1, book)).willReturn(true);
        mockMvc.perform(put("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isOk());
    }


}