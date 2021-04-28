package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccelerometerTest {

    private static final double DELTA_FOR_LOSS_TOLERANCE = 0.00000001;
    private Accelerometer classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new Accelerometer();
    }

    @Test
    public void settersGettersTest() {
        classUnderTest.setAx(0.9455502);
        classUnderTest.setAy(-1.358932);
        classUnderTest.setAz(1.855502);

        assertEquals(0.9455502,classUnderTest.getAx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(-1.358932,classUnderTest.getAy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(1.855502,classUnderTest.getAz(), DELTA_FOR_LOSS_TOLERANCE);

        assertNotNull(classUnderTest.getAx());
        assertNotNull(classUnderTest.getAy());
        assertNotNull(classUnderTest.getAz());
    }

    @Test
    public void settersGettersTest_BlankValues() {
        classUnderTest.setAx(0.0);
        classUnderTest.setAy(0.0);
        classUnderTest.setAz(0.0);

        assertEquals(0.0,classUnderTest.getAx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(0.0,classUnderTest.getAy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(0.0,classUnderTest.getAz(), DELTA_FOR_LOSS_TOLERANCE);
    }

    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getAx());
        assertNull(classUnderTest.getAy());
        assertNull(classUnderTest.getAz());
    }

    @Test
    public void parametrizedConstructor() {
        classUnderTest = new Accelerometer(0.9455502, -1.358932, 1.855502);

        assertEquals(0.9455502,classUnderTest.getAx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(-1.358932,classUnderTest.getAy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(1.855502,classUnderTest.getAz(), DELTA_FOR_LOSS_TOLERANCE);
    }
}
