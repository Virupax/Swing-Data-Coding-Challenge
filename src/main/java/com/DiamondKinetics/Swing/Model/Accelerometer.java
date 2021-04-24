package com.DiamondKinetics.Swing.Model;

public class Accelerometer {
    double ax;
    double ay;
    double az;

    Accelerometer(){
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
    }

    Accelerometer(double ax, double ay, double az){
        this.ax = ax;
        this.ay = ay;
        this.az = az;
    }

    //Getters and Setters
    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public double getAz() {
        return az;
    }

    public void setAz(double az) {
        this.az = az;
    }
}
