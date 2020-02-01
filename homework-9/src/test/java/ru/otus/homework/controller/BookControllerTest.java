package ru.otus.homework.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private CommentService commentService;

    @Test
    public void shouldReturnStartPage() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void shouldAddNewBookPost() throws Exception {
        this.mockMvc.perform(post("/addbook"))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void shouldAddNewBookGet() throws Exception {
        this.mockMvc.perform(get("/addbook")).andExpect(status().isOk());
    }

}