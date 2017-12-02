package com.rkurban.myapplication;

import android.app.Application;

import com.rkurban.myapplication.di.component.AppComponent;
import com.rkurban.myapplication.di.component.DaggerAppComponent;
import com.rkurban.myapplication.di.module.AppModule;

/**
 * Created by user on 2.12.2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
