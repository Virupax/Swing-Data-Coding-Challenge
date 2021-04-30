package com.DiamondKinetics.Swing.Model;

import java.util.List;

public class Gyroscope {
    List<Double> wx;
    List<Double> wy;
    List<Double> wz;

    Gyroscope(){
        this.wx = null;
        this.wy = null;
        this.wz = null;
    }

    Gyroscope(List<Double> wx, List<Double> wy, List<Double> wz){
        setWx(wx);
        setWy(wy);
        setWz(wz);
    }

    //Getters and Setters

    public List<Double> getWx() {
        return wx;
    }

    public void setWx(List<Double> wx) {
        this.wx = wx;
    }

    public List<Double> getWy() {
        return wy;
    }

    public void setWy(List<Double> wy) {
        this.wy = wy;
    }

    public List<Double> getWz() {
        return wz;
    }

    public void setWz(List<Double> wz) {
        this.wz = wz;
    }
}
