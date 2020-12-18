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
public class AssetRequestMessageControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    AssetRequestMessageRepository repository;

    @Test
    public void testGetAssetRequestMessageById() throws Exception {
        MockHttpServletRequestBuilder request = get("/asset-request/message/1");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.user_id", is(1)))
                .andExpect((jsonPath("$.text", is("Need this, no questions asked"))));
    }

    @Test
    public void testPostNewMessage() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> newMessage = new HashMap<String, Object>(){
            {
                put("user_id", 5);
                put("text", "Hey guys, new here, so looking for some help!");
                put("time_stamp", new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0));
                put("asset_request_id", 1);
            }
        };
        String json = objectMapper.writeValueAsString(newMessage);
            MockHttpServletRequestBuilder request = post("/asset-request/message")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json);

            this.mvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().string("Message saved in database."));
            String actual = repository.findById(2L).get().getText();
            String expected = "Hey guys, new here, so looking for some help!";
            assertEquals(expected, actual);
    }
}
