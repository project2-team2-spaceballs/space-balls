package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    UserRepository repository;

    @Test
    public void testGetUserById() throws Exception {

        MockHttpServletRequestBuilder request = get("/users/1");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.first_name", is("James")));
    }

    @Test
    public void testPostNewUser() throws Exception {

        MockHttpServletRequestBuilder request = post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"first_name\": \"Tim\",\n" +
                        "  \"last_name\":\"Dalton\",\n" +
                        "  \"phone_number\": \"4401234567\",\n" +
                        "  \"email\": \"timmyd@my.email\",\n" +
                        "  \"role\": \"Secret Agent\",\n" +
                        "  \"password\": \"drowssap\"\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("User saved in database."));
        String actual = repository.findById(5L).get().getFirst_name();
        String expected = "Tim";
        assertEquals(expected, actual);
    }

    private String getJSON(String path) throws Exception{
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}
