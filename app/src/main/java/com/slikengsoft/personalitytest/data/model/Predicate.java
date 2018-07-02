package com.slikengsoft.personalitytest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Predicate {
    @SerializedName("exactEquals")
    @Expose
    private List<String> exactEquals = null;

    public List<String> getExactEquals() {
        return exactEquals;
    }

    public void setExactEquals(List<String> exactEquals) {
        this.exactEquals = exactEquals;
    }
}
