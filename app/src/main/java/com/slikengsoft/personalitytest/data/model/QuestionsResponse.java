package com.slikengsoft.personalitytest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsResponse {
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
