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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SatelliteControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private SatelliteRepository satellite_repo;
//
//    @Test
//    @Transactional
//    @Rollback
//    public void testGetSat1() throws Exception{
//        Satellite sat1 = new Satellite();
//        sat1.setId(20000);
//        sat1.setPeriod(99.0f);
//        sat1.setInclination(55.0f);
//        sat1.setElset(70);
//        sat1.setRcs(1.00f);
//        sat1.setMission_type("Experimental Satellite");
//        sat1.setStatus(3);
//
//
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/satellites/20000")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is("20000")))
//                .andExpect(jsonPath("$.period", is("99.0")))
//                .andExpect(jsonPath("$.inclination", is("55.0")))
//                .andExpect(jsonPath("$.elset", is("70")))
//                .andExpect(jsonPath("$.rcs", is("1.00")))
//                .andExpect(jsonPath("$.mission_type", is("Experimental Satellite")))
//                .andExpect(jsonPath("$.status", is("3")));
//    }
}
