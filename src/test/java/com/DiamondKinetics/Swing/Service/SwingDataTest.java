package com.DiamondKinetics.Swing.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingDataTest {

    private ISwingData classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new SwingData();
    }


    //searchContinuityAboveValueTests
    @Test
    public void searchContinuityAboveValueTestNull(){
        ResultData resultData = classUnderTest.searchContinuityAboveValue(0, 1000, new SensorData(), 4);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTestPass(){
        ResultData resultData = classUnderTest.searchContinuityAboveValue(0, 1000, new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900), 4);

        assertEquals(727, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTestInvalidInputs(){
        ResultData resultData = classUnderTest.searchContinuityAboveValue(683, 429, new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900), 9000);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals("Wrong Indices or larger winLength", resultData.getErrorMessage());
    }


    //backSearchContinuityWithinRangeTests
    @Test
    public void backSearchContinuityWithinRangeTestNull(){
        ResultData resultData = classUnderTest.backSearchContinuityWithinRange(1000, 0, new SensorData(), new SensorData(), 4);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void backSearchContinuityWithinRangeTestPass(){
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = classUnderTest.backSearchContinuityWithinRange(1000, 0,thresholdLo, thresholdHi, 4);

        assertEquals(731, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void backSearchContinuityWithinRangeInvalidInputs(){
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = classUnderTest.backSearchContinuityWithinRange(429, 683, thresholdLo, thresholdHi, 9000);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals("Wrong Indices or larger winLength", resultData.getErrorMessage());
    }


    //searchContinuityAboveValueTwoSignalsTests
    @Test
    public void searchContinuityAboveValueTwoSignalsTestNull(){
        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals(0, 1000, new SensorData(), new SensorData(), 4);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTwoSignalsTestPass(){
        SensorData threshold1 = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData threshold2 = new SensorData(907793,0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals(0, 1000,threshold1, threshold2, 2);

        assertEquals(727, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchContinuityAboveValueTwoSignalsInvalidInputs(){
        SensorData threshold1 = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData threshold2 = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = classUnderTest.searchContinuityAboveValueTwoSignals( 683, 429, threshold1, threshold2, 9000);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals("Wrong Indices or larger winLength", resultData.getErrorMessage());
    }

    //searchMultiContinuityWithinRangeTests
    @Test
    public void searchMultiContinuityWithinRangeTestNull(){
        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange(0, 1000, new SensorData(), new SensorData(), 4);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchMultiContinuityWithinRangeTestPass(){
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange(0, 1276,thresholdLo, thresholdHi, 1);

        List<Integer> startIndices = new ArrayList<>();
        List<Integer> endIndices = new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();
        startIndices.add(727);
        startIndices.add(729);
        startIndices.add(731);
        endIndices.add(728);
        endIndices.add(730);
        endIndices.add(732);
        map.put("startIndices", startIndices);
        map.put("endIndices", endIndices);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.TRUE, resultData.getSuccess());
        assertEquals(map, resultData.getIndices());
        assertEquals(null, resultData.getErrorMessage());
    }

    @Test
    public void searchMultiContinuityWithinRangeInvalidInputs(){
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = classUnderTest.searchMultiContinuityWithinRange( 683, 429, thresholdLo, thresholdHi, 9000);

        assertEquals(null, resultData.getIndex());
        assertEquals(Boolean.FALSE, resultData.getSuccess());
        assertEquals(null, resultData.getIndices());
        assertEquals("Wrong Indices or larger winLength", resultData.getErrorMessage());
    }
}
