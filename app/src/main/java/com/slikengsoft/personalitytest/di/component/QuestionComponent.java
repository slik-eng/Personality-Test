package com.slikengsoft.personalitytest.di.component;

import com.slikengsoft.personalitytest.di.ActivityScope;
import com.slikengsoft.personalitytest.di.module.QuestionModule;
import com.slikengsoft.personalitytest.ui.base.Presenter;
import com.slikengsoft.personalitytest.ui.question.QuestionActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = QuestionModule.class)
public interface QuestionComponent {
    void inject(QuestionActivity questionActivity);

    Presenter getMainPresenter();
}
