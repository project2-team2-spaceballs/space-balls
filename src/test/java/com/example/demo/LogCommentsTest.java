package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogCommentsTest {

    LogComments logComments;

    @BeforeEach
    public void setUp(){
        logComments = new LogComments();
    }

    @Test
    public void testSetGetId() {
        logComments.setId(1L);
        Long result = logComments.getId();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetLogId() {
        logComments.setLogId(1L);
        Long result = logComments.getLogId();
        assertEquals(1, result);
    }

    @Test
    public void testSetGetDetails(){
        logComments.setDetails("A rabbit crossed the road.");
        String result = logComments.getDetails();
        assertEquals("A rabbit crossed the road.", result);
    }

    @Test
    public void testSetGetCommentDtg(){
        logComments.setComment_dtg(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime());
        Date result = logComments.getComment_dtg();
        assertEquals(new GregorianCalendar(2020, Calendar.DECEMBER, 15, 15, 10, 37).getTime(), result);
    }

}
