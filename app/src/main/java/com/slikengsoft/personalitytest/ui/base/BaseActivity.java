package com.slikengsoft.personalitytest.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.slikengsoft.personalitytest.misc.Helper;
import com.slikengsoft.personalitytest.misc.MyApplication;
import com.slikengsoft.personalitytest.di.component.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(MyApplication.get(this).getAppComponent());
        new Helper(this);
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
