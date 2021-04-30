package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.ResultData;
import com.DiamondKinetics.Swing.Model.SensorData;

import java.util.ArrayList;
import java.util.List;

//Interface driver for concrete class of SwingData Service
public interface ISwingData {
    ResultData searchContinuityAboveValue(String dataColumn,int indexBegin, int indexEnd, double threshold, int winLength);
    ResultData backSearchContinuityWithinRange(String dataColumn, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength);
    ResultData searchContinuityAboveValueTwoSignals(String dataColumn1, String dataColumn2, int indexBegin, int indexEnd, double threshold1, double threshold2, int winLength);
    ResultData searchMultiContinuityWithinRange(String dataColumn, int indexBegin, int indexEnd, double thresholdLo, double thresholdHi, int winLength);
}
