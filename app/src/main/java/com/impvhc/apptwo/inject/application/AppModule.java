package com.impvhc.apptwo.inject.application;

import android.app.Application;

import dagger.Module;
import dagger.Provides;


/**
 * Created by victor on 8/5/17.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @AppScope
    Application providesApplication() {
        return mApplication;
    }

}
