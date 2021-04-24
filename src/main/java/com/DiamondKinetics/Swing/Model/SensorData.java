package com.DiamondKinetics.Swing.Model;

public class SensorData {

    long timeStamp;
    Accelerometer accelerometer;
    Gyroscope gyroscope;

    public SensorData(){
        this.timeStamp = 0;
        this.accelerometer = new Accelerometer();
        this.gyroscope = new Gyroscope();
    }

    //Getters and Setters
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
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

    public SensorData(long timeStamp, double ax, double ay, double az, double wx, double wy, double wz){
        this.timeStamp = timeStamp;
        this. accelerometer = new Accelerometer(ax,ay,az);
        this.gyroscope = new Gyroscope(wx,wy,wz);
    }

    public boolean isGreaterThan(SensorData threshold){
        if(this.accelerometer.ax > threshold.accelerometer.ax &&
                this.accelerometer.ay > threshold.accelerometer.ay &&
                this.accelerometer.az > threshold.accelerometer.az &&
                this.gyroscope.wx > threshold.gyroscope.wx &&
                this.gyroscope.wy > threshold.gyroscope.wy &&
                this.gyroscope.wz > threshold.gyroscope.wz
        ){
            return true;
        }
        return false;
    }

    public boolean isInBetween(SensorData thresholdLo, SensorData thresholdHi){
        if(this.accelerometer.ax > thresholdLo.accelerometer.ax && this.accelerometer.ax < thresholdHi.accelerometer.ax &&
                this.accelerometer.ay > thresholdLo.accelerometer.ay &&  this.accelerometer.ax < thresholdHi.accelerometer.ax &&
                this.accelerometer.az > thresholdLo.accelerometer.az && this.accelerometer.ax < thresholdHi.accelerometer.ax &&
                this.gyroscope.wx > thresholdLo.gyroscope.wx && this.gyroscope.wx < thresholdHi.gyroscope.wx &&
                this.gyroscope.wy > thresholdLo.gyroscope.wy && this.gyroscope.wx < thresholdHi.gyroscope.wx &&
                this.gyroscope.wz > thresholdLo.gyroscope.wz && this.gyroscope.wx < thresholdHi.gyroscope.wx
        ){
            return true;
        }
        return false;
    }

}
