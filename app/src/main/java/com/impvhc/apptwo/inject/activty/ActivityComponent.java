package com.impvhc.apptwo.inject.activty;

import com.impvhc.apptwo.activity.HomeActivity;
import com.impvhc.apptwo.activity.SignInActivity;
import com.impvhc.apptwo.activity.SplashActivity;
import com.impvhc.apptwo.presenter.HomePresenter;
import com.impvhc.apptwo.presenter.SignInPresenter;
import com.impvhc.apptwo.presenter.SplashPresenter;

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

    void inject(SplashPresenter splashPresenter);

    void inject(HomePresenter homePresenter);
}
