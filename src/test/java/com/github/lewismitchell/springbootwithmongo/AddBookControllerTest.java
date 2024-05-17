package com.github.lewismitchell.springbootwithmongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AddBookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void onPageLoadTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/books/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("AddBook"));
    }

    @Test
    public void onSubmitTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/books/add")
                        .param("name", "foo")
                        .param("author", "bar")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("AddedBook"));
    }

    @Test
    public void onSubmitFailedValidationMissingNameTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/books/add")
                        .param("author", "bar")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("AddBook"));
    }

    @Test
    public void onSubmitFailedValidationMissingAuthorTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/books/add")
                        .param("name", "foo")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("AddBook"));
    }
}
