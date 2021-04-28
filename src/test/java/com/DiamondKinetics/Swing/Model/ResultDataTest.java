package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDataTest {
    private ResultData classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new ResultData();
    }

    @Test
    public void settersGettersTest() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(12);
        startIndices.add(21);
        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(17);
        endIndices.add(26);
        map.put("startIndices", startIndices);
        map.put("endIndices", endIndices);

        classUnderTest.setIndex(198);
        classUnderTest.setErrorMessage("Wrong Indices");
        classUnderTest.setSuccess(true);
        classUnderTest.setIndices(map);

        assertEquals((Integer) 198,classUnderTest.getIndex());
        assertEquals(map,classUnderTest.getIndices());
        assertEquals("Wrong Indices",classUnderTest.getErrorMessage());
        assertEquals(Boolean.TRUE,classUnderTest.getSuccess());

        assertNotNull(classUnderTest.getIndex());
        assertNotNull(classUnderTest.getIndices());
        assertNotNull(classUnderTest.getErrorMessage());
        assertNotNull(classUnderTest.getSuccess());
    }


    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getIndex());
        assertNull(classUnderTest.getIndices());
        assertNull(classUnderTest.getErrorMessage());
        assertNull(classUnderTest.getSuccess());
    }


}
