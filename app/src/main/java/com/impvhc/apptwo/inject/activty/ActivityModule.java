package com.impvhc.apptwo.inject.activty;

import android.app.Activity;

import com.impvhc.apptwo.presenter.SignInPresenter;
import com.impvhc.apptwo.view.SignInView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by victor on 8/4/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public SignInView signInView(){
        return new SignInView(activity);
    }

    @Provides
    @ActivityScope
    public SignInPresenter signInPresenter(SignInView view){
        return new SignInPresenter(view);
    }

}
