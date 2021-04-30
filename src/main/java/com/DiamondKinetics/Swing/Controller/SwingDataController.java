package com.DiamondKinetics.Swing.Controller;

import com.DiamondKinetics.Swing.Service.ISwingData;
import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import com.DiamondKinetics.Swing.Service.SwingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SwingDataController {

    @Autowired
    private ISwingData iSwingData;

    //GET /api/v1/search-continuity-above-value
    @RequestMapping("/search-continuity-above-value")
    public ResponseEntity<ResultData> searchContinuity(@RequestParam("dataColumn") String dataColumn,
                                                           @RequestParam("indexBegin") String indexBegin,
                                                           @RequestParam("indexEnd") String indexEnd,
                                                           @RequestParam("threshold") String threshold,
                                                           @RequestParam("winLength") String winLength) {

        ResultData resultData = iSwingData.searchContinuityAboveValue(dataColumn, Integer.parseInt(indexBegin), Integer.parseInt(indexEnd), Double.parseDouble(threshold), Integer.parseInt(winLength));
        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/back-search-continuity-within-range
    @RequestMapping("/back-search-continuity-within-range")
    public ResponseEntity<ResultData> backSearchContinuity(@RequestParam("dataColumn") String dataColumn,
                                                               @RequestParam("indexBegin") String indexBegin,
                                                               @RequestParam("indexEnd") String indexEnd,
                                                               @RequestParam("thresholdLo") String thresholdLo,
                                                               @RequestParam("thresholdHi") String thresholdHi,
                                                               @RequestParam("winLength") String winLength) {

        ResultData resultData = iSwingData.backSearchContinuityWithinRange(dataColumn,Integer.parseInt(indexBegin), Integer.parseInt(indexEnd), Double.parseDouble(thresholdLo), Double.parseDouble(thresholdHi), Integer.parseInt(winLength));
        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    //GET /api/v1/search-continuity-above-two-values
    @RequestMapping("/search-continuity-above-two-values")
    public ResponseEntity<ResultData> searchContinuityTwoValues(@RequestParam("dataColumn1") String dataColumn1,
                                                                    @RequestParam("dataColumn2") String dataColumn2,
                                                                    @RequestParam("indexBegin") String indexBegin,
                                                                    @RequestParam("indexEnd") String indexEnd,
                                                                    @RequestParam("threshold1") String threshold1,
                                                                    @RequestParam("threshold2") String threshold2,
                                                                    @RequestParam("winLength") String winLength) {

        ResultData resultData = iSwingData.searchContinuityAboveValueTwoSignals(dataColumn1,dataColumn2, Integer.parseInt(indexBegin), Integer.parseInt(indexEnd), Double.parseDouble(threshold1), Double.parseDouble(threshold2), Integer.parseInt(winLength));
        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }

    //GET /api/v1/search-multiContinuity-within-range
    @RequestMapping("/search-multiContinuity-within-range")
    public ResponseEntity<ResultData> searchMultiContinuity(@RequestParam("dataColumn") String dataColumn,
                                                                @RequestParam("indexBegin") String indexBegin,
                                                                @RequestParam("indexEnd") String indexEnd,
                                                                @RequestParam("thresholdLo") String thresholdLo,
                                                                @RequestParam("thresholdHi") String thresholdHi,
                                                                @RequestParam("winLength") String winLength) {
        ResultData resultData = iSwingData.searchMultiContinuityWithinRange(dataColumn,Integer.parseInt(indexBegin), Integer.parseInt(indexEnd), Double.parseDouble(thresholdLo), Double.parseDouble(thresholdHi), Integer.parseInt(winLength));
        return new ResponseEntity<>(resultData, HttpStatus.OK);

    }
}
