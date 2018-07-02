package com.slikengsoft.personalitytest.misc;

import android.app.Application;
import android.content.Context;

import com.slikengsoft.personalitytest.di.component.AppComponent;
import com.slikengsoft.personalitytest.di.component.DaggerAppComponent;


public class MyApplication extends Application {
    private AppComponent appComponent;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
