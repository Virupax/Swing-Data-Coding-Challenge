package com.DiamondKinetics.Swing.Model;

import com.DiamondKinetics.Swing.Util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SensorData {
    public static final String SENSORDATAFILENAME = "/data/latestSwing.csv";

    List<Long> timeStamp;
    Accelerometer accelerometer;
    Gyroscope gyroscope;


    @Autowired
    public SensorData(){
        SensorData temp =  FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME);
        this.timeStamp = temp.getTimeStamp();
        this.accelerometer = temp.getAccelerometer();
        this.gyroscope = temp.getGyroscope();
    }

    //Getters and Setters
    public List<Long> getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(List<Long> timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Accelerometer getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(Accelerometer accelerometer) {
        this.accelerometer = accelerometer;
    }

    public Gyroscope getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(Gyroscope gyroscope) {
        this.gyroscope = gyroscope;
    }

    public SensorData(List<Long> timeStamp, List<Double> ax, List<Double> ay, List<Double> az, List<Double> wx, List<Double> wy, List<Double> wz){
        this.timeStamp = timeStamp;
        this. accelerometer = new Accelerometer(ax,ay,az);
        this.gyroscope = new Gyroscope(wx,wy,wz);
    }


    public List<Double> getColumnData(SwingDataColumn dataColumn){
        List<Double> data;

        switch (dataColumn){
            case ax:    data = this.getAccelerometer().getAx();
                break;
            case ay :   data = this.getAccelerometer().getAy();
                break;
            case az :   data = this.getAccelerometer().getAz();
                break;
            case wx :   data = this.getGyroscope().getWx();
                break;
            case wy :   data = this.getGyroscope().getWy();
                break;
            case wz :   data = this.getGyroscope().getWz();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dataColumn);
        }
        return data;
    }

}
