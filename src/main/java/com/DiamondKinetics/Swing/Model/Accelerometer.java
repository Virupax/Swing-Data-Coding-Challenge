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
}
