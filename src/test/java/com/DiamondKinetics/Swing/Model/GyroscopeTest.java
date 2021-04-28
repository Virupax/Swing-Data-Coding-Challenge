package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GyroscopeTest {

    private static final double DELTA_FOR_LOSS_TOLERANCE = 0.00000001;
    private Gyroscope classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new Gyroscope();
    }

    @Test
    public void settersGettersTest() {
        classUnderTest.setWx(0.9455502);
        classUnderTest.setWy(-1.358932);
        classUnderTest.setWz(1.855502);

        assertEquals(0.9455502,classUnderTest.getWx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(-1.358932,classUnderTest.getWy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(1.855502,classUnderTest.getWz(), DELTA_FOR_LOSS_TOLERANCE);

        assertNotNull(classUnderTest.getWx());
        assertNotNull(classUnderTest.getWy());
        assertNotNull(classUnderTest.getWz());
    }

    @Test
    public void settersGettersTest_BlankValues() {
        classUnderTest.setWx(0.0);
        classUnderTest.setWy(0.0);
        classUnderTest.setWz(0.0);

        assertEquals(0.0,classUnderTest.getWx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(0.0,classUnderTest.getWy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(0.0,classUnderTest.getWz(), DELTA_FOR_LOSS_TOLERANCE);
    }

    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getWx());
        assertNull(classUnderTest.getWy());
        assertNull(classUnderTest.getWz());
    }

    @Test
    public void parametrizedConstructor() {
        classUnderTest = new Gyroscope(0.9455502, -1.358932, 1.855502);

        assertEquals(0.9455502,classUnderTest.getWx(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(-1.358932,classUnderTest.getWy(), DELTA_FOR_LOSS_TOLERANCE);
        assertEquals(1.855502,classUnderTest.getWz(), DELTA_FOR_LOSS_TOLERANCE);
    }

}
