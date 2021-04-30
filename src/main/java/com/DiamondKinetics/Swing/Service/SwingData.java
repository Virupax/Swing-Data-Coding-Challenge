package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import com.DiamondKinetics.Swing.Model.SwingDataColumn;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


//Concrete implementation of the interface ISwingData
public class SwingData implements ISwingData {


    private SensorData sensorData;
    private IValidateSwingData iValidateSwingData;

    @Autowired
    public SwingData(){
        this.sensorData = new SensorData();
        this.iValidateSwingData = new ValidateSwingData();
    }



    /**
     * Search winLength number of Sensor Data which are above threshold within indexBegin and indexEnd
     *
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param threshold
     * @param winLength
     * @return ResultData
     * */
    private ResultData searchContinuityAboveValue(List<Double> data, int indexBegin, int indexEnd, double threshold, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        Predicate<Double> greaterThanThreshold = i -> i > threshold;
        Predicate<Double> alwaysTrue = i -> true;
        Predicate<Integer> indexLimit = i -> i < indexEnd;

        int indexMatchingCriteria = searchForCriteria(data, data, indexBegin, indexEnd, 1,  winLength, greaterThanThreshold, alwaysTrue, indexLimit);
        if(indexMatchingCriteria > -1){
            resultData.setIndex(indexMatchingCriteria);
            resultData.setSuccess(Boolean.TRUE);
        }
        return resultData;
    }

    /**
     * BackSearch winLength number of Sensor Data which are above thresholdLo and below thresholdHi within indexBegin and indexEnd
     *
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return ResultData
     * */
    private ResultData backSearchContinuityWithinRange(List<Double> data, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        Predicate<Double> withInThreshold = i -> i > thresholdLo && i < thresholdHi;
        Predicate<Double> alwaysTrue = i -> true;
        Predicate<Integer> indexLimit = i -> i > indexEnd;

        int indexMatchingCriteria = searchForCriteria(data, data, indexBegin, indexEnd, -1,  winLength, withInThreshold, alwaysTrue, indexLimit);
        if(indexMatchingCriteria > -1) {
            resultData.setIndex(indexMatchingCriteria);
            resultData.setSuccess(Boolean.TRUE);
        }
        return resultData;
    }

    /**
     * Search winLength number of two Sensor signals which are above threshold1 and threshold2 respectively within indexBegin and indexEnd
     *
     * @param data1
     * @param data2
     * @param indexBegin
     * @param indexEnd
     * @param threshold1
     * @param threshold2
     * @param winLength
     * @return ResultData
     * */
    private ResultData searchContinuityAboveValueTwoSignals(List<Double> data1, List<Double> data2, int indexBegin, int indexEnd, double threshold1, double threshold2, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        Predicate<Double> list1Threshold = i -> i > threshold1;
        Predicate<Double> list2Threshold = i -> i > threshold2;
        Predicate<Integer> indexLimit = i -> i < indexEnd;

        int indexMatchingCriteria = searchForCriteria(data1, data2, indexBegin, indexEnd, 1,  winLength, list1Threshold, list2Threshold, indexLimit);
        if(indexMatchingCriteria > -1){
            resultData.setIndex(indexMatchingCriteria);
            resultData.setSuccess(Boolean.TRUE);
        }
        return resultData;
    }

    /**
     * Search multiple rows of size winLength of a Sensor signal which are above thresholdLo and below thresholdHi respectively within indexBegin and indexEnd
     *
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return ResultData
     * */
    private ResultData searchMultiContinuityWithinRange(List<Double> data, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        List<Integer> startIndices = new ArrayList<>();
        List<Integer> endIndices = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        Predicate<Double> withInThreshold = i -> i > thresholdLo && i < thresholdHi;
        Predicate<Double> alwaysTrue = i -> true;
        Predicate<Integer> indexLimit = i -> i < indexEnd;

        for(int i = indexBegin; i<indexEnd; i++){
            int indexMatchingCriteria = searchForCriteria(data, data, i, indexEnd, 1, winLength, withInThreshold, alwaysTrue, indexLimit);
            if (indexMatchingCriteria > -1) {
                startIndices.add(indexMatchingCriteria);
                endIndices.add(indexMatchingCriteria + winLength);
                resultData.setSuccess(Boolean.TRUE);
                i = indexMatchingCriteria;
            }
        }
        map.put("startIndices", startIndices);
        map.put("endIndices", endIndices);
        resultData.setIndices(map);

        return resultData;
    }


    @Override
    public ResultData searchContinuityAboveValue(String dataColumn, int indexBegin, int indexEnd, double threshold, int winLength){
        ResultData resultData = new ResultData();
        try {
            iValidateSwingData.validateDataInputColumn(dataColumn);
            iValidateSwingData.validateBounds(indexBegin, indexEnd, sensorData.getTimeStamp().size());
            iValidateSwingData.validateWinLength(indexBegin, indexEnd, winLength);

            resultData = searchContinuityAboveValue(sensorData.getColumnData(SwingDataColumn.valueOf(dataColumn)), indexBegin, indexEnd, threshold, winLength);

        }catch (IllegalArgumentException ex){
            resultData.setSuccess(Boolean.FALSE);
            resultData.setErrorMessage(ex.getMessage());
        }
        return resultData;
    }
    @Override
    public ResultData backSearchContinuityWithinRange(String dataColumn, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength) {
        ResultData resultData = new ResultData();
        try{
            iValidateSwingData.validateDataInputColumn(dataColumn);
            iValidateSwingData.validateReverseBounds(indexBegin, indexEnd, sensorData.getTimeStamp().size());
            iValidateSwingData.validateWinLength(indexEnd, indexBegin, winLength);
            iValidateSwingData.validateThresholds(thresholdLo, thresholdHi);

            resultData = backSearchContinuityWithinRange(sensorData.getColumnData(SwingDataColumn.valueOf(dataColumn)), indexBegin, indexEnd, thresholdLo, thresholdHi, winLength);

        }catch (IllegalArgumentException ex){
            resultData.setSuccess(Boolean.FALSE);
            resultData.setErrorMessage(ex.getMessage());
        }
        return resultData;
    }
    @Override
    public ResultData searchContinuityAboveValueTwoSignals(String dataColumn1, String dataColumn2, int indexBegin, int indexEnd, double threshold1, double threshold2, int winLength){
        ResultData resultData = new ResultData();
        try {
            iValidateSwingData.validateDataInputColumn(dataColumn1);
            iValidateSwingData.validateDataInputColumn(dataColumn2);
            iValidateSwingData.validateBounds(indexBegin, indexEnd, sensorData.getTimeStamp().size());
            iValidateSwingData.validateWinLength(indexBegin, indexEnd, winLength);

            resultData = searchContinuityAboveValueTwoSignals(sensorData.getColumnData(SwingDataColumn.valueOf(dataColumn1)), sensorData.getColumnData(SwingDataColumn.valueOf(dataColumn2)), indexBegin, indexEnd, threshold1, threshold2, winLength);

        }catch (IllegalArgumentException ex){
            resultData.setSuccess(Boolean.FALSE);
            resultData.setErrorMessage(ex.getMessage());
        }
        return resultData;
    }
    @Override
    public ResultData searchMultiContinuityWithinRange(String dataColumn, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength){
        ResultData resultData = new ResultData();
        try {
            iValidateSwingData.validateDataInputColumn(dataColumn);
            iValidateSwingData.validateBounds(indexBegin, indexEnd, sensorData.getTimeStamp().size());
            iValidateSwingData.validateThresholds(thresholdLo, thresholdHi);
            resultData = searchMultiContinuityWithinRange(sensorData.getColumnData(SwingDataColumn.valueOf(dataColumn)), indexBegin, indexEnd, thresholdLo, thresholdHi, winLength);
        }catch (IllegalArgumentException ex){
            resultData.setSuccess(Boolean.FALSE);
            resultData.setErrorMessage(ex.getMessage());
        }
        return resultData;
    }

    private int searchForCriteria(List<Double> data1, List<Double> data2, int indexBegin, int indexEnd, int step, int winLength, Predicate<Double> predicate1, Predicate<Double> predicate2, Predicate<Integer> predicate3){
        int indexMatchingCriteria = -1;
        for (int i = indexBegin; predicate3.test(i); i+=step) {
            if ( predicate1.test(data1.get(i)) && predicate2.test(data2.get(i))) {
                int tempWinLength = winLength;
                while (tempWinLength > 0 && predicate1.test(data1.get(i)) && predicate2.test(data2.get(i))) {
                    tempWinLength--;
                    i+=step;
                }
                if (tempWinLength == 0) {
                    indexMatchingCriteria = i - winLength;
                    break;
                }
            }
        }
        return indexMatchingCriteria;
    }

}
