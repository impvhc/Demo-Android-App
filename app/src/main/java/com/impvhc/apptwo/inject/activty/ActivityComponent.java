package com.impvhc.apptwo.inject.activty;

import com.impvhc.apptwo.activity.HomeActivity;
import com.impvhc.apptwo.activity.SignInActivity;
import com.impvhc.apptwo.activity.SplashActivity;
import com.impvhc.apptwo.presenter.SignInPresenter;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by victor on 8/4/17.
 */
@ActivityScope
@Subcomponent(modules = { ActivityModule.class })
public interface ActivityComponent {
    void inject(SignInActivity signInActivity);
    void inject(SignInPresenter signInPresenter);
    void inject(HomeActivity homeActivity);
    void inject(SplashActivity splashActivity);
}
