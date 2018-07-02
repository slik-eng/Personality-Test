package com.slikengsoft.personalitytest.di.module;

import android.app.Application;

import com.slikengsoft.personalitytest.misc.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  private MyApplication myApplication;

  public AppModule(MyApplication myApplication) {
    this.myApplication = myApplication;
  }

  @Provides
  @Singleton public Application provideApplication() {
    return myApplication;
  }
}
