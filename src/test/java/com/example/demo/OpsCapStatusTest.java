package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class OpsCapStatusTest {

    OpsCapStatus opsCapStatus;

    @BeforeEach
    public void setup() {
        opsCapStatus = new OpsCapStatus();
    }

    @Test
    public void testsetId() {
        opsCapStatus.setId(3L);
        long results = opsCapStatus.getId();

        assertEquals(3L, results);
    }

    @Test
    public void testsetcolot() {
        opsCapStatus.setColor("red");
        String results = opsCapStatus.getColor();

        assertEquals("red", results);
    }
}
