package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;
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
    @Transactional
    @Rollback
    public void testGetAssetRequestById() throws Exception {
        AssetRequest newRequest;
        newRequest = new AssetRequest();
        newRequest.setUserId(1L);
        newRequest.setSat_id(2237L);
        newRequest.setPass_start(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        newRequest.setPass_stop(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 20, 0).getTime());
        newRequest.setLatitude(37.37f);
        newRequest.setLongitude(-37.37f);
        newRequest.setElevation(37);
        newRequest.setStatus("pending");
        this.repository.save(newRequest);

        MockHttpServletRequestBuilder request = get("/asset-request/1");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.userId", is(1)))
                .andExpect((jsonPath("$.latitude", is(37.37))));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAssetRequestByUserId() throws Exception {
        AssetRequest newRequest;
        newRequest = new AssetRequest();
        newRequest.setUserId(5L);
        newRequest.setSat_id(2238L);
        newRequest.setPass_start(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        newRequest.setPass_stop(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 20, 0).getTime());
        newRequest.setLatitude(-38f);
        newRequest.setLongitude(38f);
        newRequest.setElevation(38);
        newRequest.setStatus("pending");
        this.repository.save(newRequest);

        MockHttpServletRequestBuilder request = get("/asset-request/userId/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId", is(5)))
                .andExpect((jsonPath("$[0].latitude", is(37.37))))
                .andExpect(jsonPath("$[1].userId", is(5)))
                .andExpect((jsonPath("$[1].latitude", is(38.0))));
    }

    @Test
    @Transactional
    @Rollback
    public void testPostNewRequest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> newRequest = new HashMap<String, Object>(){
            {
                put("userId", 5);
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
                .andExpect((jsonPath("$", is(35))));;

    }


}
