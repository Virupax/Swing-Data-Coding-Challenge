package com.DiamondKinetics.Swing.Controller;

import com.DiamondKinetics.Swing.Service.ISwingData;
import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import com.DiamondKinetics.Swing.Service.SwingData;
import com.DiamondKinetics.Swing.Util.FileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
//@RequestMapping("/api/v1/")
public class SwingDataController {

    ArrayList<SensorData> sensorData = null;

    //Just for Demonstration Purpose
    private ArrayList<SensorData> readSensorData()  {
        this.sensorData = null;
        try{
            this.sensorData = FileUtil.readCSVtoSensorDataList();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return this.sensorData;
    }


    @RequestMapping("/search-continuity-above-value")
    public ResponseEntity<ResultData> demoSearchContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValue(this.sensorData, 0, this.sensorData.size(), threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    @RequestMapping("/back-search-continuity-within-range")
    public ResponseEntity<ResultData> demoBackSearchContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        SensorData thresholdLo = new SensorData();
        SensorData thresholdHi = new SensorData();
        ResultData resultData = iSwingData.backSearchContinuityWithinRange(this.sensorData, 0, this.sensorData.size(), thresholdLo, thresholdHi, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    @RequestMapping("/search-continuity-above-two-values")
    public ResponseEntity<ResultData> demoSearchContinuityTwoValues() {
        ISwingData iSwingData = new SwingData();

        if(this.sensorData == null){
            readSensorData();
        }

        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValueTwoSignals(this.sensorData, this.sensorData, 0, this.sensorData.size(), threshold, threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    @RequestMapping("/search-multicontinuity-within-range")
    public ResponseEntity<ResultData> demoSearchMultiContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        SensorData thresholdLo = new SensorData();
        SensorData thresholdHi = new SensorData();
        ResultData resultData = iSwingData.searchMultiContinuityWithinRange(this.sensorData, 0, this.sensorData.size(), thresholdLo, thresholdHi, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }
}
