package com.DiamondKinetics.Swing.Service;

public interface IValidateSwingData {
    public void validateBounds(int indexBegin, int indexEnd, int swingDataLength);
    public void validateReverseBounds(int indexBegin, int indexEnd, int swingDataLength);
    public void validateWinLength(int indexBegin, int indexEnd, int winLength);
    public void validateThresholds(double threshold1, double threshold2);
    public void validateDataInputColumn(String dataColumn);
}
