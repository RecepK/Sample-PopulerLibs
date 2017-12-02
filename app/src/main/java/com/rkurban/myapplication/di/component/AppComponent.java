package com.rkurban.myapplication.di.component;

import android.app.Application;

import com.rkurban.myapplication.MainActivity;
import com.rkurban.myapplication.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by user on 2.12.2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    /*
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder app(Application application);

        AppComponent build();
    }*/

    void inject(MainActivity mainActivity);

}
