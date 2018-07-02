package com.slikengsoft.personalitytest.di.module;

import com.slikengsoft.personalitytest.data.api.Questions;
import com.slikengsoft.personalitytest.ui.base.Presenter;
import com.slikengsoft.personalitytest.ui.question.QuestionPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class QuestionModule {
    private QuestionPresenter.View view;

    public QuestionModule(QuestionPresenter.View view) {
        this.view = view;
    }

    @Provides public QuestionPresenter.View provideView() {
        return view;
    }

    @Provides public Presenter provideCategoryPresenter(Questions questions, QuestionPresenter.View questionView) {
        return new QuestionPresenter(questions, questionView);
    }
}
