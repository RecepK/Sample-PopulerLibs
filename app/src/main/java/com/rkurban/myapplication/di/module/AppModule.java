package com.rkurban.myapplication.di.module;

import android.app.Application;

import com.rkurban.myapplication.part.rx.Rxx;
import com.rkurban.myapplication.part.toast.MToast;
import com.rkurban.myapplication.part.web.WebHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 2.12.2017.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }


    @Singleton
    @Provides
    Rxx rxx() {
        return new Rxx();
    }

    @Singleton
    @Provides
    MToast toast() {
        return new MToast(application);
    }

    @Singleton
    @Provides
    WebHelper webHelper() {
        return new WebHelper();
    }
}
