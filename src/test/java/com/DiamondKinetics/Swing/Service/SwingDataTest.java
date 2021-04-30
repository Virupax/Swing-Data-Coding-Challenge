package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.ResultData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SwingDataTest {

    private ISwingData classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new SwingData();
    }


    //searchContinuityAboveValueTests
//    @Test
//    public void searchContinuityAboveValueTestNull(){
//        ResultData resultData = classUnderTest.searchContinuityAboveValue("ax", 0, 1000, 0.998492, 4);
//
//        assertEquals(37, resultData.getIndex());
//        assertEquals(Boolean.TRUE, resultData.getSuccess());
//        assertEquals(null, resultData.getIndices());
//        assertEquals(null, resultData.getErrorMessage());
//    }

    @Test
    public void searchContinuityAboveValueTestPass(){
        ResultData resultData = classUnderTest.searchContinuityAboveValue("ax", 0, 1000, 0.998492, 4);

        assertEquals(37, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTestInvalidInputs(){
        ResultData resultData = classUnderTest.searchContinuityAboveValue("ay",683, 429, 0.390000, 9000);
        assertEquals("indexBegin cannot be greater than indexEnd", resultData.getErrorMessage());
//        assertTrue(e instanceof IllegalArgumentException);
    }


    //backSearchContinuityWithinRangeTests
//    @Test
//    public void backSearchContinuityWithinRangeTestNull(){
//        ResultData resultData = classUnderTest.backSearchContinuityWithinRange(1000, 0, new SensorData(), new SensorData(), 4);
//
//        assertEquals(null, resultData.getIndex());
//        assertEquals(Boolean.FALSE, resultData.getSuccess());
//        assertEquals(null, resultData.getIndices());
//        assertEquals(null, resultData.getErrorMessage());
//    }

    @Test
    public void backSearchContinuityWithinRangeTestPass(){
        ResultData resultData = classUnderTest.backSearchContinuityWithinRange("ay", 900, 400, 0.998492, 4.395353,4);

        assertEquals(815, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void backSearchContinuityWithinRangeInvalidInputs(){
        ResultData resultData =  classUnderTest.backSearchContinuityWithinRange("wx", 380, 0, 4.390000, 3.0, 3);
        assertEquals("thresholdLo cannot be greater than thresholdHi", resultData.getErrorMessage());
//        assertTrue(e instanceof IllegalArgumentException);
    }


//searchContinuityAboveValueTwoSignalsTests
//    @Test
//    public void searchContinuityAboveValueTwoSignalsTestNull(){
//        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals(0, 1000, new SensorData(), new SensorData(), 4);
//
//        assertEquals(null, resultData.getIndex());
//        assertEquals(Boolean.FALSE, resultData.getSuccess());
//        assertEquals(null, resultData.getIndices());
//        assertEquals(null, resultData.getErrorMessage());
//    }

    @Test
    public void searchContinuityAboveValueTwoSignalsTestPass(){
        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals("ax", "ay", 0, 1276, -1.00, 3.3535, 2);

        assertEquals(906, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTwoSignalsInvalidInputs(){
        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals("ax", "ay", 0, 1276, -1.00, 3.3535, 20);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    //searchMultiContinuityWithinRangeTests
//    @Test
//    public void searchMultiContinuityWithinRangeTestNull(){
//        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange(0, 1000, new SensorData(), new SensorData(), 4);
//
//        assertEquals(null, resultData.getIndex());
//        assertEquals(Boolean.FALSE, resultData.getSuccess());
//        assertEquals(null, resultData.getIndices());
//        assertEquals(null, resultData.getErrorMessage());
//    }

    @Test
    public void searchMultiContinuityWithinRangeTestPass(){
        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange("ax",0, 1275, 1.353, 1.8986, 5);

        List<Integer> startIndices = new ArrayList<>(Arrays.asList(48, 49, 50, 51, 52, 53, 54, 55));
        List<Integer> endIndices = new ArrayList<>(Arrays.asList(53, 54, 55, 56, 57, 58, 59, 60));
        Map<String,List<Integer>> map = new HashMap<>();
        map.put("startIndices", startIndices);
        map.put("endIndices", endIndices);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(map.get("startIndices"), resultData.getIndices().get("startIndices"));
        assertEquals(map.get("endIndices"), resultData.getIndices().get("endIndices"));
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchMultiContinuityWithinRangeNotFoundCase(){
        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange("ax",0, 1275, 4.353, 5.8986, 5);

        List<Integer> startIndices = new ArrayList<>();
        List<Integer> endIndices = new ArrayList<>();

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(startIndices, resultData.getIndices().get("startIndices"));
        assertEquals(endIndices, resultData.getIndices().get("endIndices"));
        assertEquals(null, resultData.getErrorMessage());
    }
}
