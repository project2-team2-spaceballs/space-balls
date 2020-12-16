package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

@SpringBootTest
@AutoConfigureMockMvc
public class LogsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LogsRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testGetAllLogs() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);

        MockHttpServletRequestBuilder request = get("/logs")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].details", is("This is the first entry")));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAllLogById() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);
        Logs log2;
        log2 = new Logs();
        log2.setSensor_id(1L);
        log2.setDetails("This is the second entry");
        log2.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log2);

        MockHttpServletRequestBuilder request = get("/logs/" + log2.getId())
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.details", is("This is the second entry")));
    }

    @Test
    @Transactional
    @Rollback
    public void testPostLogEntry() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> newLog = new HashMap<String, Object>(){
            {
                put("sensor_id", 1);
                put("details", "This is my new log entry");
                put("entry_dtg", new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0));
            }
        };
        String json = objectMapper.writeValueAsString(newLog);

        MockHttpServletRequestBuilder request = post("/logs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.details", is("This is my new log entry")));
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateLogEntryAndAddToHistory() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> updatedLog = new HashMap<String, Object>(){
            {
                put("id", log1.getId());
                put("details", "This is my updated log entry.");
            }
        };
        String json = objectMapper.writeValueAsString(updatedLog);

        MockHttpServletRequestBuilder request = patch("/logs/" + log1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(log1.getId().intValue())))
                .andExpect(jsonPath("$.details", is("This is my updated log entry.")));
    }

    @Test
    @Transactional
    @Rollback
    public void testArchiveAnEntry() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> updatedLog = new HashMap<String, Object>(){
            {
                put("id", log1.getId());
                put("archived", true);
            }
        };
        String json = objectMapper.writeValueAsString(updatedLog);

        MockHttpServletRequestBuilder request = patch("/logs/" + log1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(log1.getId().intValue())))
                .andExpect(jsonPath("$.archived", is(true)));
    }

    @Test
    @Transactional
    @Rollback
    public void testSearchEntriesReturnsOne() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);
        Logs log2;
        log2 = new Logs();
        log2.setSensor_id(1L);
        log2.setDetails("This is the second entry");
        log2.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log2);

        MockHttpServletRequestBuilder request = get("/logs/find?search=second")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].details", is("This is the second entry")));
    }

    @Test
    @Transactional
    @Rollback
    public void testSearchEntriesReturnsTwoMissCased() throws Exception {
        Logs log1;
        log1 = new Logs();
        log1.setSensor_id(1L);
        log1.setDetails("This is the first entry");
        log1.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log1);
        Logs log2;
        log2 = new Logs();
        log2.setSensor_id(1L);
        log2.setDetails("This is the second entry");
        log2.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        repository.save(log2);

        MockHttpServletRequestBuilder request = get("/logs/find?search=tHis")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].details", is("This is the first entry")))
                .andExpect(jsonPath("$[1].details", is("This is the second entry")));
    }
}
