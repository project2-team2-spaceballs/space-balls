package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogsTest {

    Logs log;

    @BeforeEach
    public void setUp(){
        log = new Logs();
    }

    @Test
    public void testSetGetId() {
        log.setId(1L);
        Long result = log.getId();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetSensorId() {
        log.setSensor_id(1L);
        Long result = log.getSensor_id();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetDetails(){
        log.setDetails("A rabbit crossed the road.");
        String result = log.getDetails();
        assertEquals("A rabbit crossed the road.", result);
    }

    @Test
    public void testSetGetEntryDtg(){
        log.setEntry_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime());
        Date result = log.getEntry_dtg();
        assertEquals(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime(), result);
    }

    @Test
    public void testSetGetArchived(){
        log.setArchived(true);
        boolean result = log.isArchived();
        assertTrue(result);
    }

}
