package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PassesControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private PassesRepository passes_repo;
//
//    @Test
//    @Transactional
//    @Rollback
//    public void testGetPass1() throws Exception{
//        Passes pass1 = new Passes();
//        pass1.setId(31);
//        pass1.setSat_id(20000);
//        pass1.setPass_start(new GregorianCalendar(2020, Calendar.DECEMBER, 01, 00, 00, 0).getTime());
//        pass1.setPass_stop(new GregorianCalendar(2020, Calendar.DECEMBER, 01, 00, 10, 0).getTime());
//        pass1.setToes(0.00f);
//        pass1.setNk_fence(false);
//        pass1.setK_fence(false);
//        passes_repo.save(pass1);
//
//
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/passes/20000")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is("31")))
//                .andExpect(jsonPath("$.sat_id", is("20000")))
//                .andExpect(jsonPath("$.pass_start", is("2020-12-01 00:00:00")))
//                .andExpect(jsonPath("$.pass_stop", is("2020-12-01 00:10:00")))
//                .andExpect(jsonPath("$.toes", is("0.00")))
//                .andExpect(jsonPath("$.nk_fence", is("false")))
//                .andExpect(jsonPath("$.k_fence", is("false")));
//    }

}
