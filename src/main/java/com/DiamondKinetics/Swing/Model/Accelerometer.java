package com.DiamondKinetics.Swing.Model;

public class Accelerometer {
    Double ax;
    Double ay;
    Double az;

    Accelerometer(){
        this.ax = null;
        this.ay = null;
        this.az = null;
    }

    Accelerometer(double ax, double ay, double az){
        setAx(ax);
        setAy(ay);
        setAz(az);
    }

    //Getters and Setters

    public Double getAx() {
        return ax;
    }

    public void setAx(Double ax) {
        this.ax = ax;
    }

    public Double getAy() {
        return ay;
    }

    public void setAy(Double ay) {
        this.ay = ay;
    }

    public Double getAz() {
        return az;
    }

    public void setAz(Double az) {
        this.az = az;
    }
}
