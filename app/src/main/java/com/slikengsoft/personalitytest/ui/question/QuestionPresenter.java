package com.slikengsoft.personalitytest.ui.question;

import com.slikengsoft.personalitytest.data.api.Questions;
import com.slikengsoft.personalitytest.data.model.Callback;
import com.slikengsoft.personalitytest.data.model.Question;
import com.slikengsoft.personalitytest.data.model.QuestionsResponse;
import com.slikengsoft.personalitytest.ui.base.Presenter;

import java.util.ArrayList;
import java.util.List;

public class QuestionPresenter implements Presenter, Callback{
    private Questions questions;
    private View view;

    public QuestionPresenter(Questions questions, View view) {
        this.questions = questions;
        this.view = view;
    }

    @Override
    public void onResume() {
        view.showProgress();
        questions.getQuestions(this, false);
    }

    @Override
    public void onItemSelected(Question question, int position) {
        view.showMessage(String.format("Question Category: " + question.getCategory() + " Position %d clicked", position));
    }

    @Override
    public void onLoadCategories(QuestionsResponse questionsResponse) {
        view.showQuestions(questionsResponse.getQuestions());
        view.showCategories(questionsResponse.getCategories());
        view.hideProgress();

    }

    public interface View {

        void showProgress();

        void hideProgress();

        void showQuestions(List<Question> questions);

        void showMessage(String message);

        void showCategories(List<String> categories);
    }
}
