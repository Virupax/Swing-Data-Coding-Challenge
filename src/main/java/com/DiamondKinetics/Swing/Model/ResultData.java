package com.DiamondKinetics.Swing.Model;

import java.util.List;
import java.util.Map;

//Model for Response of API calls
public class ResultData {
    private  Integer index;
    private Map<String, List<Integer>> indices;
    private Boolean isSuccess;
    private String errorMessage;

    //Getters and Setters

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Map<String, List<Integer>> getIndices() {
        return indices;
    }

    public void setIndices(Map<String, List<Integer>> indices) {
        this.indices = indices;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
