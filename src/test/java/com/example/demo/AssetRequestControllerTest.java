package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AssetRequestControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    AssetRequestRepository repository;


    @Test
    public void testGetAssetRequestById() throws Exception {
        MockHttpServletRequestBuilder request = get("/asset-request/1");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.user_id", is(1)))
                .andExpect((jsonPath("$.latitude", is(41.7532))));
    }

    @Test
    public void testPostNewRequest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> newRequest = new HashMap<String, Object>(){
            {
                put("user_id", 5);
                put("sat_id", 1);
                put("pass_start", new GregorianCalendar(2020, Calendar.DECEMBER, 23, 15, 10, 0));
                put("pass_stop", new GregorianCalendar(2020, Calendar.DECEMBER, 23, 17, 0, 0));
                put("latitude", 37.37);
                put("longitude", -37.37);
                put("elevation", 37.37);
                put("status", "approved");
            }
        };

        String json = objectMapper.writeValueAsString(newRequest);
        MockHttpServletRequestBuilder request = post("/asset-request")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Request saved in database."));
        String actual = repository.findById(5L).get().getStatus();
        String expected = "approved";
        assertEquals(expected, actual);
    }


}
