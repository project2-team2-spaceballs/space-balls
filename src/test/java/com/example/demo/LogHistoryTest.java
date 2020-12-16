package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogHistoryTest {

    LogHistory logHistory;

    @BeforeEach
    public void setUp(){
        logHistory = new LogHistory();
    }

    @Test
    public void testSetGetId() {
        logHistory.setId(1L);
        Long result = logHistory.getId();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetLogId() {
        logHistory.setLog_id(1L);
        Long result = logHistory.getLog_id();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetDetails(){
        logHistory.setDetails("A rabbit crossed the road.");
        String result = logHistory.getDetails();
        assertEquals("A rabbit crossed the road.", result);
    }

    @Test
    public void testSetGetOriginalDtg(){
        logHistory.setOriginal_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime());
        Date result = logHistory.getOriginal_dtg();
        assertEquals(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime(), result);
    }

    @Test
    public void testSetGetUpdatedDtg(){
        logHistory.setUpdated_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime());
        Date result = logHistory.getUpdated_dtg();
        assertEquals(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime(), result);
    }


}
