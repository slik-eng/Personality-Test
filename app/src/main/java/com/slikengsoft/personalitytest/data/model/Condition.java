package com.slikengsoft.personalitytest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {
    @SerializedName("predicate")
    @Expose
    private Predicate predicate;
    @SerializedName("if_positive")
    @Expose
    private IfPositive ifPositive;

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public IfPositive getIfPositive() {
        return ifPositive;
    }

    public void setIfPositive(IfPositive ifPositive) {
        this.ifPositive = ifPositive;
    }

}
