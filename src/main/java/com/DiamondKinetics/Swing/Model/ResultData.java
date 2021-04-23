package com.DiamondKinetics.Swing.Model;

import java.util.List;
import java.util.Map;

public class ResultData {
    private  int index;
    private Map<String, List<Integer>> indices;
    private String errorMessage;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Map<String, List<Integer>> getIndices() {
        return indices;
    }

    public void setIndices(Map<String, List<Integer>> indices) {
        this.indices = indices;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
