package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MxControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    MxRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testGetAll() throws Exception {
        MockHttpServletRequestBuilder request = get("/mx/all")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]id", instanceOf(Number.class) ))
                .andExpect(jsonPath("$[0]mx_id", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]mx_title", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]description", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]sensors", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]type", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]approved", instanceOf(String.class) ));
    }
    @Test
    @Transactional
    @Rollback
    public void testSensor() throws Exception {
        MockHttpServletRequestBuilder request = get("/mx/sensor/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]id", instanceOf(Number.class) ))
                .andExpect(jsonPath("$[0]mx_id", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]mx_title", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]description", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]sensors", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]type", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]approved", instanceOf(String.class) ));
    }
    @Test
    @Transactional
    @Rollback
    public void testRequest() throws Exception {
        MockHttpServletRequestBuilder request = post("/mx/request")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"mx_id\": \"test\"," +
                        "\"mx_title\": \"test\", " +
                        "\"description\":\"test desc\"," +
                        " \"sensors\": \"testsensor\"," +
                        "\"type\": \"Scheduled\"," +
                        "\"approved\":\"Pending\"}");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ))
                .andExpect(jsonPath("$.mx_id", instanceOf(String.class) ))
                .andExpect(jsonPath("$.mx_title", instanceOf(String.class) ))
                .andExpect(jsonPath("$.description", instanceOf(String.class) ))
                .andExpect(jsonPath("$.sensors", instanceOf(String.class) ))
                .andExpect(jsonPath("$.type", instanceOf(String.class) ))
                .andExpect(jsonPath("$.approved", instanceOf(String.class) ));
    }
    @Test
    @Transactional
    @Rollback
    public void testSearch() throws Exception {
        MockHttpServletRequestBuilder request = get("/mx/search?searchstring=1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]id", instanceOf(Number.class) ))
                .andExpect(jsonPath("$[0]mx_id", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]mx_title", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]description", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]sensors", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]type", instanceOf(String.class) ))
                .andExpect(jsonPath("$[0]approved", instanceOf(String.class) ));
    }
}
