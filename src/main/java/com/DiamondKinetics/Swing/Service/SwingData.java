package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;
import com.DiamondKinetics.Swing.Util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Concrete implementation of the interface ISwingData
public class SwingData implements ISwingData {

    public static final String SENSORDATAFILENAME = "/data/latestSwing.csv";


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
    @Override
    public ResultData searchContinuityAboveValue(ArrayList<SensorData> data , int indexBegin, int indexEnd, SensorData threshold, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        if(indexEnd < indexBegin || indexEnd - indexBegin < winLength){
            resultData.setErrorMessage("Wrong Indices or larger winLength");
            return resultData;
        }
        try {
            int indexMatchingCriteria = -1;
            for (int i = indexBegin; i < indexEnd; i++) {
                if (data.get(i).isGreaterThan(threshold)) {
                    int tempWinLength = winLength;
                    while (tempWinLength > 0 && data.get(i).isGreaterThan(threshold)) {
                        tempWinLength--;
                        i++;
                    }
                    if (tempWinLength == 0) {
                        indexMatchingCriteria = i - winLength;
                        resultData.setSuccess(Boolean.TRUE);
                        break;
                    }
                }
            }
            resultData.setIndex(indexMatchingCriteria);
        }catch (Exception ex){
            resultData.setErrorMessage(ex.getMessage());
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
    @Override
    public ResultData backSearchContinuityWithinRange(ArrayList<SensorData> data, int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        if(indexEnd > indexBegin || indexEnd - indexBegin > winLength){
            resultData.setErrorMessage("Wrong Indices or larger winLength");
            return resultData;
        }

        try {
            int indexMatchingCriteria = -1;
            for (int i = indexBegin; i > indexEnd; i--) {
                if (data.get(i).isInBetween(thresholdLo, thresholdHi)) {
                    int tempWinLength = winLength;
                    while (tempWinLength > 0 && data.get(i).isInBetween(thresholdLo, thresholdHi)) {
                        tempWinLength--;
                        i--;
                    }
                    if (tempWinLength == 0) {
                        indexMatchingCriteria = i + winLength;
                        resultData.setSuccess(Boolean.TRUE);
                        break;
                    }
                }
            }
            resultData.setIndex(indexMatchingCriteria);
        }catch (Exception ex){
            resultData.setErrorMessage(ex.getMessage());
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
    @Override
    public ResultData searchContinuityAboveValueTwoSignals(ArrayList<SensorData> data1, ArrayList<SensorData> data2, int indexBegin, int indexEnd, SensorData threshold1, SensorData threshold2, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        if(indexEnd < indexBegin || indexEnd - indexBegin < winLength){
            resultData.setErrorMessage("Wrong Indices or larger winLength");
            return resultData;
        }

        try {
            int indexMatchingCriteria = -1;
            for (int i = indexBegin; i < indexEnd; i++) {
                if (data1.get(i).isGreaterThan(threshold1) && data2.get(i).isGreaterThan(threshold2)) {
                    int tempWinLength = winLength;
                    while (tempWinLength > 0 && data1.get(i).isGreaterThan(threshold1) && data2.get(i).isGreaterThan(threshold2)) {
                        tempWinLength--;
                        i++;
                    }
                    if (tempWinLength == 0) {
                        indexMatchingCriteria = i - winLength;
                        resultData.setSuccess(Boolean.TRUE);
                        break;
                    }
                }
            }
            resultData.setIndex(indexMatchingCriteria > 0 ? indexMatchingCriteria : null);
        }catch (Exception ex){
            resultData.setErrorMessage(ex.getMessage());
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
    @Override
    public ResultData searchMultiContinuityWithinRange(ArrayList<SensorData> data, int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(Boolean.FALSE);

        if(indexEnd < indexBegin || indexEnd - indexBegin < winLength){
            resultData.setErrorMessage("Wrong Indices or larger winLength");
            return resultData;
        }

        List<Integer> startIndices = new ArrayList<>();
        List<Integer> endIndices = new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();

        try {
            for (int i = indexBegin; i < indexEnd; i++) {
                if (data.get(i).isInBetween(thresholdLo, thresholdHi)) {
                    int tempWinLength = winLength;
                    while (tempWinLength > 0 && data.get(i).isInBetween(thresholdLo, thresholdHi)) {
                        tempWinLength--;
                        i++;
                    }
                    if (tempWinLength == 0) {
                        startIndices.add(i - winLength);
                        endIndices.add(i);
                        resultData.setSuccess(Boolean.TRUE);
                    }
                }
            }
            map.put("startIndices", startIndices);
            map.put("endIndices", endIndices);
            resultData.setIndices(map);
        }catch (Exception ex){
            resultData.setErrorMessage(ex.getMessage());
        }
        return resultData;
    }

    @Override
    public ResultData searchContinuityAboveValue(int indexBegin, int indexEnd, SensorData threshold, int winLength){
        ResultData resultData = searchContinuityAboveValue(FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME), indexBegin, indexEnd, threshold, winLength);
        return resultData;
    }
    @Override
    public ResultData backSearchContinuityWithinRange(int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength) {
        ResultData resultData = backSearchContinuityWithinRange(FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME), indexBegin, indexEnd, thresholdLo, thresholdHi, winLength);
        return resultData;
    }
    @Override
    public ResultData searchContinuityAboveValueTwoSignals(int indexBegin, int indexEnd, SensorData threshold1, SensorData threshold2, int winLength){
        ResultData resultData = searchContinuityAboveValueTwoSignals(FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME), FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME), indexBegin, indexEnd, threshold1, threshold2, winLength);
        return resultData;
    }
    @Override
    public ResultData searchMultiContinuityWithinRange(int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength){
        ResultData resultData = searchMultiContinuityWithinRange(FileUtil.readCSVtoSensorDataList(SENSORDATAFILENAME), indexBegin, indexEnd, thresholdLo, thresholdHi, winLength);
        return resultData;
    }

}
