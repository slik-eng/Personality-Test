package com.slikengsoft.personalitytest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionType_ {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("range")
    @Expose
    private Range range;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

}
