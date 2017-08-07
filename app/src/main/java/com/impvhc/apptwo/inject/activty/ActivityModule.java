package com.impvhc.apptwo.inject.activty;

import android.content.Context;

import com.impvhc.apptwo.presenter.HomePresenter;
import com.impvhc.apptwo.presenter.SignInPresenter;
import com.impvhc.apptwo.presenter.SplashPresenter;
import com.impvhc.apptwo.view.HomeView;
import com.impvhc.apptwo.view.SignInView;
import com.impvhc.apptwo.view.SplashView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by victor on 8/4/17.
 */

@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public SignInView signInView(){
        return new SignInView(context);
    }

    @Provides
    @ActivityScope
    public SignInPresenter signInPresenter(SignInView view){
        return new SignInPresenter(view);
    }

    @Provides
    @ActivityScope
    public HomeView homeView(){
        return new HomeView(context);
    }

    @Provides
    @ActivityScope
    public HomePresenter homePresenter(HomeView view){
        return new HomePresenter(view);
    }

    @Provides
    @ActivityScope
    public SplashView splashView(){
        return new SplashView(context);
    }

    @Provides
    @ActivityScope
    public SplashPresenter splashPresenter(SplashView view){
        return new SplashPresenter(view);
    }

}
