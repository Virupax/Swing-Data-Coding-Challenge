package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccelerometerTest {

    private static final double DELTA_FOR_LOSS_TOLERANCE = 0.00000001;
    private Accelerometer classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new Accelerometer();
    }

    @Test
    public void settersGettersTest() {
        List<Double> values = new ArrayList<>();
        values.add(0.9455502);
        values.add(-1.358932);
        values.add(1.855502);

        classUnderTest.setAx(values);
        classUnderTest.setAy(values);
        classUnderTest.setAz(values);

        assertEquals(values,classUnderTest.getAx());
        assertEquals(values, classUnderTest.getAy());
        assertEquals(values,classUnderTest.getAz());

        assertNotNull(classUnderTest.getAx());
        assertNotNull(classUnderTest.getAy());
        assertNotNull(classUnderTest.getAz());
    }

    @Test
    public void settersGettersTest_BlankValues() {
        classUnderTest.setAx(new ArrayList<>());
        classUnderTest.setAy(new ArrayList<>());
        classUnderTest.setAz(new ArrayList<>());

        assertEquals(new ArrayList<>(),classUnderTest.getAx());
        assertEquals(new ArrayList<>(),classUnderTest.getAy());
        assertEquals(new ArrayList<>(),classUnderTest.getAz());
    }

    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getAx());
        assertNull(classUnderTest.getAy());
        assertNull(classUnderTest.getAz());
    }

    @Test
    public void parametrizedConstructor() {
        List<Double> values = new ArrayList<>();
        values.add(0.9455502);
        values.add(-1.358932);
        values.add(1.855502);

        classUnderTest = new Accelerometer(values, values, values);

        assertEquals(values,classUnderTest.getAx());
        assertEquals(values,classUnderTest.getAy());
        assertEquals(values,classUnderTest.getAz());
    }
}
