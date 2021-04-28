package com.DiamondKinetics.Swing.Model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class SensorDataTest {
    private SensorData classUnderTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeEach
    public void setup() {
        classUnderTest = new SensorData();
    }

    @Test
    public void settersGettersTest() {

        Accelerometer accelerometer = new Accelerometer(0.9455502, -1.358932, 1.855502);
        Gyroscope gyroscope = new Gyroscope(0.9455502, -1.358932, 1.855502);


        classUnderTest.setTimeStamp(2435353L);
        classUnderTest.setAccelerometer(accelerometer);
        classUnderTest.setGyroscope(gyroscope);

        assertEquals((Long) 2435353L,classUnderTest.getTimeStamp());
        assertEquals(accelerometer,classUnderTest.getAccelerometer());
        assertEquals(gyroscope,classUnderTest.getGyroscope());

        assertNotNull(classUnderTest.getTimeStamp());
        assertNotNull(classUnderTest.getAccelerometer());
        assertNotNull(classUnderTest.getGyroscope());
    }


    @Test
    public void settersGettersTest_NullValues() {
        assertNull(classUnderTest.getTimeStamp());
        assertNull(classUnderTest.getAccelerometer());
        assertNull(classUnderTest.getGyroscope());
    }

    @Test
    public void classMethodsIsGreaterThan(){
        Throwable e = null;

        try {
            classUnderTest.isGreaterThan(new SensorData());
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof NullPointerException);

        SensorData sensorData = new SensorData();
        Accelerometer accelerometer = new Accelerometer(0.9455502, -1.358932, 1.855502);
        Gyroscope gyroscope = new Gyroscope(0.9455502, -1.358932, 1.855502);
        sensorData.setTimeStamp(2435353L);
        sensorData.setAccelerometer(accelerometer);
        sensorData.setGyroscope(gyroscope);

        SensorData threshold = new SensorData();
        accelerometer = new Accelerometer(0.9455501, -1.358933, 1.855501);
        gyroscope = new Gyroscope(0.9455501, -1.358933, 1.855501);
        threshold.setAccelerometer(accelerometer);
        threshold.setGyroscope(gyroscope);

        assertEquals(Boolean.TRUE, sensorData.isGreaterThan(threshold));


        accelerometer = new Accelerometer(0.9455503, -1.358931, 1.855503);
        gyroscope = new Gyroscope(0.9455503, -1.358931, 1.855503);
        threshold.setAccelerometer(accelerometer);
        threshold.setGyroscope(gyroscope);

        assertEquals(Boolean.FALSE, sensorData.isGreaterThan(threshold));
    }


    @Test
    public void classMethodsIsInBetween(){
        Throwable e = null;

        try {
            classUnderTest.isInBetween(new SensorData(), new SensorData());
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof NullPointerException);

        SensorData sensorData = new SensorData();
        Accelerometer accelerometer = new Accelerometer(0.9455502, -1.358932, 1.855502);
        Gyroscope gyroscope = new Gyroscope(0.9455502, -1.358932, 1.855502);
        sensorData.setTimeStamp(2435353L);
        sensorData.setAccelerometer(accelerometer);
        sensorData.setGyroscope(gyroscope);

        SensorData thresholdLo = new SensorData();
        accelerometer = new Accelerometer(0.9455501, -1.358933, 1.855501);
        gyroscope = new Gyroscope(0.9455501, -1.358933, 1.855501);
        thresholdLo.setAccelerometer(accelerometer);
        thresholdLo.setGyroscope(gyroscope);

        SensorData thresholdHi = new SensorData();
        accelerometer = new Accelerometer(0.9455503, -1.358930, 1.855503);
        gyroscope = new Gyroscope(0.9455503, -1.358931, 1.855503);
        thresholdHi.setAccelerometer(accelerometer);
        thresholdHi.setGyroscope(gyroscope);


        assertEquals(Boolean.TRUE, sensorData.isInBetween(thresholdLo,thresholdHi));

        accelerometer = new Accelerometer(0.9455500, -1.358933, 1.855500);
        gyroscope = new Gyroscope(0.9455500, -1.358933, 1.855500);
        thresholdHi.setAccelerometer(accelerometer);
        thresholdHi.setGyroscope(gyroscope);

        assertEquals(Boolean.FALSE, sensorData.isInBetween(thresholdLo,thresholdHi));
    }

}
