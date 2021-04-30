package com.DiamondKinetics.Swing.Service;

import com.DiamondKinetics.Swing.Model.SwingDataColumn;

public class ValidateSwingData implements IValidateSwingData{
    @Override
    public void validateBounds(int indexBegin, int indexEnd, int swingDataLength) {
        if(indexBegin > indexEnd){
            throw new IllegalArgumentException("indexBegin cannot be greater than indexEnd");
        }
        validateBoundsWithDataLength(indexBegin, indexEnd, swingDataLength);
    }

    @Override
    public void validateReverseBounds(int indexBegin, int indexEnd, int swingDataLength) {
        if(indexBegin < indexEnd){
            throw new IllegalArgumentException("indexBegin cannot be lesser than indexEnd");
        }
        validateBoundsWithDataLength(indexBegin, indexEnd, swingDataLength);
    }

    @Override
    public void validateWinLength(int indexBegin, int indexEnd, int winLength) {
        if(indexEnd - indexBegin < winLength){
            throw new IllegalArgumentException("winLength cannot be greater than search range");
        }
    }

    @Override
    public void validateThresholds(double thresholdLo, double thresholdHi) {
        if(thresholdLo > thresholdHi){
            throw new IllegalArgumentException("thresholdLo cannot be greater than thresholdHi");
        }
    }

    @Override
    public void validateDataInputColumn(String dataColumn){
        if(!SwingDataColumn.isValid(dataColumn)){
            throw new IllegalArgumentException("Invalid data column requested");
        }
    }

    private void validateBoundsWithDataLength(int indexBegin, int indexEnd, int swingDataLength){
        if(indexBegin > swingDataLength || indexEnd > swingDataLength){
            throw new IllegalArgumentException("indexBegin or indexEnd cannot be greater than swingDataLength");
        }
    }


}
