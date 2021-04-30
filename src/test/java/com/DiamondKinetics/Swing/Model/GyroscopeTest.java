package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GyroscopeTest {

    private static final double DELTA_FOR_LOSS_TOLERANCE = 0.00000001;
    private Gyroscope classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new Gyroscope();
    }

    @Test
    public void settersGettersTest() {
        List<Double> values = new ArrayList<>();
        values.add(0.9455502);
        values.add(-1.358932);
        values.add(1.855502);

        classUnderTest.setWx(values);
        classUnderTest.setWy(values);
        classUnderTest.setWz(values);

        assertEquals(values,classUnderTest.getWx());
        assertEquals(values, classUnderTest.getWy());
        assertEquals(values,classUnderTest.getWz());

        assertNotNull(classUnderTest.getWx());
        assertNotNull(classUnderTest.getWy());
        assertNotNull(classUnderTest.getWz());
    }

    @Test
    public void settersGettersTest_BlankValues() {
        classUnderTest.setWx(new ArrayList<>());
        classUnderTest.setWy(new ArrayList<>());
        classUnderTest.setWz(new ArrayList<>());

        assertEquals(new ArrayList<>(),classUnderTest.getWx());
        assertEquals(new ArrayList<>(),classUnderTest.getWy());
        assertEquals(new ArrayList<>(),classUnderTest.getWz());
    }

    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getWx());
        assertNull(classUnderTest.getWy());
        assertNull(classUnderTest.getWz());
    }

    @Test
    public void parametrizedConstructor() {
        List<Double> values = new ArrayList<>();
        values.add(0.9455502);
        values.add(-1.358932);
        values.add(1.855502);

        classUnderTest = new Gyroscope(values, values, values);

        assertEquals(values,classUnderTest.getWx());
        assertEquals(values,classUnderTest.getWy());
        assertEquals(values,classUnderTest.getWz());
    }

}
