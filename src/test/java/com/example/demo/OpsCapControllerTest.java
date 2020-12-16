package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class OpsCapControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    OpscapRepo repository;

    @Test
    @Transactional
    @Rollback
    public void testGetOpsCap() throws Exception {

        OpsCap opsCap = new OpsCap();

        opsCap.setId(3L);
        opsCap.setRadar_id(2L);
        opsCap.setSda_stat(4L);
        opsCap.setMd_stat(2L);
        opsCap.setMw_stat(4L);
        opsCap.setDetails("Testing");

        repository.save(opsCap);

        MockHttpServletRequestBuilder request = get("/opscap")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].details", is("Testing")));
    }


}
