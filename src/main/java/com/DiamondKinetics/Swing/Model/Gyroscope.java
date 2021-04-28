package com.DiamondKinetics.Swing.Model;

public class Gyroscope {
    Double wx;
    Double wy;
    Double wz;

    Gyroscope(){
        this.wx = null;
        this.wy = null;
        this.wz = null;
    }

    Gyroscope(double wx, double wy, double wz){
        setWx(wx);
        setWy(wy);
        setWz(wz);
    }

    //Getters and Setters

    public Double getWx() {
        return wx;
    }

    public void setWx(Double wx) {
        this.wx = wx;
    }

    public Double getWy() {
        return wy;
    }

    public void setWy(Double wy) {
        this.wy = wy;
    }

    public Double getWz() {
        return wz;
    }

    public void setWz(Double wz) {
        this.wz = wz;
    }
}
