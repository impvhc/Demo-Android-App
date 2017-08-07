package com.impvhc.apptwo;

import android.app.Application;
import android.content.Context;

import com.impvhc.apptwo.inject.application.AppComponent;
import com.impvhc.apptwo.inject.application.AppModule;
import com.impvhc.apptwo.inject.application.DaggerAppComponent;
import com.impvhc.apptwo.inject.application.NetworkModule;

/**
 * Created by victor on 8/6/17.
 */

public class TwoApplication extends Application{

    AppComponent mComponent;

    public static TwoApplication get(Context context) {
        return (TwoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Dagger%COMPONENT_NAME%
        mComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .networkModule(new NetworkModule("http://192.168.1.135:1337/parse/"))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
    }

    public AppComponent getComponent() {
        return mComponent;
    }

}
