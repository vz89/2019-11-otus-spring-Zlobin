package ru.otus.homework.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.homework.repo.UserRepository;
import ru.otus.homework.service.AuthorService;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;
import ru.otus.homework.service.GenreService;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ComponentScan("ru.otus.homework.service")
@WebMvcTest(controllers = BookController.class)
@MockBeans({@MockBean(BookService.class), @MockBean(AuthorService.class), @MockBean(GenreService.class), @MockBean(CommentService.class), @MockBean(UserRepository.class)})
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @WithMockUser(username = "admin")
    @Test
    void shouldReturnStartPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("books"));
    }

    @WithMockUser(username = "admin")
    @Test
    void shouldAddNewBookGet() throws Exception {
        this.mockMvc.perform(get("/addbook")).andExpect(status().isOk());
    }

    @WithMockUser(username = "admin")
    @Test
    void isAuthenticated() throws Exception {
        mockMvc.perform(get("/")).andExpect(authenticated());
    }

    @WithMockUser(username = "admin")
    @Test
    void addBookAuthenticated() throws Exception {
        mockMvc.perform(post("/addbook")).andExpect(authenticated());
    }

    @WithMockUser(username = "admin")
    @Test
    void deleteBookAuthenticated() throws Exception {
        mockMvc.perform(post("/delete/1")).andExpect(authenticated());
    }

    @WithMockUser(username = "admin")
    @Test
    void editBookAuthenticated() throws Exception {
        mockMvc.perform(post("/edit/1")).andExpect(authenticated());
    }

    @WithMockUser(username = "admin")
    @Test
    void showBookAuthenticated() throws Exception {
        mockMvc.perform(post("/view/1")).andExpect(authenticated());
    }


    @Test
    void getBooksNotAuthenticated() throws Exception {
        mockMvc.perform(get("/")).andExpect(unauthenticated());
    }

    @Test
    void addBookNotAuthenticated() throws Exception {
        mockMvc.perform(post("/addbook")).andExpect(unauthenticated());
    }

    @Test
    void deleteBookNotAuthenticated() throws Exception {
        mockMvc.perform(post("/delete/1")).andExpect(unauthenticated());
    }

    @Test
    void editBookNotAuthenticated() throws Exception {
        mockMvc.perform(post("/edit/1")).andExpect(unauthenticated());
    }

    @Test
    void showBookNotAuthenticated() throws Exception {
        mockMvc.perform(post("/view/1")).andExpect(unauthenticated());
    }
}