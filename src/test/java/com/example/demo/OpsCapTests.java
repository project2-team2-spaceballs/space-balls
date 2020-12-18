package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class OpsCapTests {

    OpsCap opsCap;

    @BeforeEach
    public void setup(){
         opsCap = new OpsCap();
    }

    @Test
    public void testsetId() {

        opsCap.setId(3L);
        long results = opsCap.getId();

        assertEquals(3L, results);
    }

    @Test
    public void testsetRadar() {
        opsCap.setRadar_id(3L);
        long results = opsCap.getRadar_id();

        assertEquals(3L, results);
    }

    @Test
    public void testMw_stat() {
        opsCap.setMw_stat(4L);
        long results = opsCap.getMw_stat();

        assertEquals(4L, results);
    }

    @Test
    public void testMd_stat() {
        opsCap.setMd_stat(4L);
        long results = opsCap.getMd_stat();

        assertEquals(4L, results);
    }

    @Test
    public void testSda_stat() {
        opsCap.setSda_stat(4L);
        long results = opsCap.getSda_stat();

        assertEquals(4L, results);
    }

    @Test
    public void testDetails() {
        opsCap.setDetails("Hello this is working");

        String result = opsCap.getDetails();

        assertEquals("Hello this is working", result);
    }


}
