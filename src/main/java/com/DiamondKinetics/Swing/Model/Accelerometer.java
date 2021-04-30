package com.DiamondKinetics.Swing.Model;

import java.util.List;

public class Accelerometer {
    List<Double> ax;
    List<Double> ay;
    List<Double> az;

    Accelerometer(){
        this.ax = null;
        this.ay = null;
        this.az = null;
    }

    Accelerometer(List<Double> ax, List<Double> ay, List<Double> az){
        setAx(ax);
        setAy(ay);
        setAz(az);
    }

    //Getters and Setters


    public List<Double> getAx() {
        return ax;
    }

    public void setAx(List<Double> ax) {
        this.ax = ax;
    }

    public List<Double> getAy() {
        return ay;
    }

    public void setAy(List<Double> ay) {
        this.ay = ay;
    }

    public List<Double> getAz() {
        return az;
    }

    public void setAz(List<Double> az) {
        this.az = az;
    }
}
