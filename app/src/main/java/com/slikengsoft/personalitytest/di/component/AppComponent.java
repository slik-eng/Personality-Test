package com.slikengsoft.personalitytest.di.component;

import com.slikengsoft.personalitytest.misc.MyApplication;
import com.slikengsoft.personalitytest.data.api.Questions;
import com.slikengsoft.personalitytest.di.module.AppModule;
import com.slikengsoft.personalitytest.di.module.InterActorsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {
        AppModule.class, InterActorsModule.class}) public interface AppComponent {
    void inject(MyApplication categoryApplication);

    Questions getItemsInterActor();
}
