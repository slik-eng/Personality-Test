package com.slikengsoft.personalitytest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionType {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    @SerializedName("condition")
    @Expose
    private Condition condition;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
