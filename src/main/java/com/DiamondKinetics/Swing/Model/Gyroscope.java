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
}
