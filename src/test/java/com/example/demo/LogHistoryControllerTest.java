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

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LogHistoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LogHistoryRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testGetHistoryByLogId() throws Exception {
        LogHistory log1 = new LogHistory();
        log1.setLogId(1L);
        log1.setDetails("This is the first history entry");
        log1.setOriginal_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0).getTime());
        log1.setUpdated_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 20, 0).getTime());
        repository.save(log1);
        LogHistory log2 = new LogHistory();
        log2.setLogId(1L);
        log2.setDetails("This is the second history entry");
        log2.setOriginal_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 20, 0).getTime());
        log2.setUpdated_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 16, 10, 0).getTime());
        repository.save(log2);

        MockHttpServletRequestBuilder request = get("/logs/history/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].details", is("This is the first history entry")))
                .andExpect(jsonPath("$[1].details", is("This is the second history entry")));
    }

    @Test
    @Transactional
    @Rollback
    public void testPostToHistory() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> newLog = new HashMap<String, Object>(){
            {
                put("log_id", 1);
                put("details", "This is my new log history entry");
                put("original_dtg", new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 0));
                put("updated_dtg", new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 20, 0));
            }
        };
        String json = objectMapper.writeValueAsString(newLog);

        MockHttpServletRequestBuilder request = post("/logs/history")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.details", is("This is my new log history entry")));
    }

}
