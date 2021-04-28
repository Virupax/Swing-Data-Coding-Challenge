package com.DiamondKinetics.Swing.Controller;

import com.DiamondKinetics.Swing.Service.ISwingData;
import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import com.DiamondKinetics.Swing.Service.SwingData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SwingDataController {


    //GET /api/v1/search-continuity-above-value
    @RequestMapping("/search-continuity-above-value")
    public ResponseEntity<ResultData> demoSearchContinuity() {
        ISwingData iSwingData = new SwingData();

        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValue(0, -1, threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/back-search-continuity-within-range
    @RequestMapping("/back-search-continuity-within-range")
    public ResponseEntity<ResultData> demoBackSearchContinuity() {
        ISwingData iSwingData = new SwingData();

        //Hardcoded values for demo
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = iSwingData.backSearchContinuityWithinRange( -1, 0, thresholdLo, thresholdHi, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    //GET /api/v1/search-continuity-above-two-values
    @RequestMapping("/search-continuity-above-two-values")
    public ResponseEntity<ResultData> demoSearchContinuityTwoValues() {
        ISwingData iSwingData = new SwingData();

        //Both data1 and data2 is passed same data, but tried with different lists and working
        SensorData threshold = new SensorData();
        ResultData resultData = iSwingData.searchContinuityAboveValueTwoSignals(0, -1, threshold, threshold, 4);

        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/search-multiContinuity-within-range
    @RequestMapping("/search-multiContinuity-within-range")
    public ResponseEntity<ResultData> demoSearchMultiContinuity() {
        ISwingData iSwingData = new SwingData();

        //Hardcoded values for demo
        SensorData thresholdLo = new SensorData(912785, 0.390000, 0.530000, 0.012694, 1.333692,4.85540,0.472900);
        SensorData thresholdHi = new SensorData(907793,0.460000,0.545900,0.083946,1.600009,5.35542,0.478972);
        ResultData resultData = iSwingData.searchMultiContinuityWithinRange(0, -1, thresholdLo, thresholdHi, 1);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }
}
