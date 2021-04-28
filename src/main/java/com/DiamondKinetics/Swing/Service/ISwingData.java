package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;

import java.util.ArrayList;

//Interface driver for concrete class of SwingData Service
public interface ISwingData {
    ResultData searchContinuityAboveValue(ArrayList<SensorData> data, int indexBegin, int indexEnd, SensorData threshold, int winLength);
    ResultData backSearchContinuityWithinRange(ArrayList<SensorData> data, int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength);
    ResultData searchContinuityAboveValueTwoSignals(ArrayList<SensorData> data1, ArrayList<SensorData> data2, int indexBegin, int indexEnd, SensorData threshold1, SensorData threshold2, int winLength);
    ResultData searchMultiContinuityWithinRange(ArrayList<SensorData> data, int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength);

    ResultData searchContinuityAboveValue(int indexBegin, int indexEnd, SensorData threshold, int winLength);

    ResultData backSearchContinuityWithinRange(int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength);

    ResultData searchContinuityAboveValueTwoSignals(int indexBegin, int indexEnd, SensorData threshold1, SensorData threshold2, int winLength);

    ResultData searchMultiContinuityWithinRange(int indexBegin, int indexEnd, SensorData thresholdLo, SensorData thresholdHi, int winLength);
}
