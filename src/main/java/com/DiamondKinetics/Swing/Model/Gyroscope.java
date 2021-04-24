package com.DiamondKinetics.Swing.Model;

public class Gyroscope {
    double wx;
    double wy;
    double wz;

    Gyroscope(){
        this.wx = 0;
        this.wy = 0;
        this.wz = 0;
    }

    Gyroscope(double wx, double wy, double wz){
        this.wx = wx;
        this.wy = wy;
        this.wz = wz;
    }

    //Getters and Setters
    public double getWx() {
        return wx;
    }

    public void setWx(double wx) {
        this.wx = wx;
    }

    public double getWy() {
        return wy;
    }

    public void setWy(double wy) {
        this.wy = wy;
    }

    public double getWz() {
        return wz;
    }

    public void setWz(double wz) {
        this.wz = wz;
    }
}
