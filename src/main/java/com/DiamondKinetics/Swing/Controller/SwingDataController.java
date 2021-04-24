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
@RequestMapping("/api/v1/")
public class SwingDataController {

    ArrayList<SensorData> sensorData = null;

    //Demonstration Purpose
    private ArrayList<SensorData> readSensorData()  {
        this.sensorData = null;
        try{
            this.sensorData = FileUtil.readCSVtoSensorDataList();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return this.sensorData;
    }


    //GET /api/v1/search-continuity-above-value
    @RequestMapping("/search-continuity-above-value")
    public ResponseEntity<ResultData> demoSearchContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValue(this.sensorData, 0, this.sensorData.size()-1, threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/back-search-continuity-within-range
    @RequestMapping("/back-search-continuity-within-range")
    public ResponseEntity<ResultData> demoBackSearchContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        //Hardcoded values for demo
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = iSwingData.backSearchContinuityWithinRange(this.sensorData, this.sensorData.size()-1, 0, thresholdLo, thresholdHi, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    //GET /api/v1/search-continuity-above-two-values
    @RequestMapping("/search-continuity-above-two-values")
    public ResponseEntity<ResultData> demoSearchContinuityTwoValues() {
        ISwingData iSwingData = new SwingData();

        if(this.sensorData == null){
            readSensorData();
        }

        //Both data1 and data2 is passed same data, but tried with different lists and working
        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValueTwoSignals(this.sensorData, this.sensorData, 0, this.sensorData.size()-1, threshold, threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/search-multicontinuity-within-range
    @RequestMapping("/search-multicontinuity-within-range")
    public ResponseEntity<ResultData> demoSearchMultiContinuity() {
        ISwingData iSwingData = new SwingData();
        if(this.sensorData == null){
            readSensorData();
        }

        //Hardcoded vlaues for demo
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = iSwingData.searchMultiContinuityWithinRange(this.sensorData, 0, this.sensorData.size()-1, thresholdLo, thresholdHi, 1);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }
}
