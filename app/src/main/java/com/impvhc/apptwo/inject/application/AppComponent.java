package com.impvhc.apptwo.inject.application;

import com.impvhc.apptwo.inject.activty.ActivityComponent;
import com.impvhc.apptwo.inject.activty.ActivityModule;

import dagger.Component;

/**
 * Created by victor on 8/5/17.
 */

@AppScope
@Component(modules = { AppModule.class, NetworkModule.class})
public interface AppComponent {
    ActivityComponent plus(ActivityModule activityModule);
}
