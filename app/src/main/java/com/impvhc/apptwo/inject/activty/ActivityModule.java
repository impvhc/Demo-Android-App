package com.impvhc.apptwo.inject.activty;

import android.content.Context;

import com.impvhc.apptwo.presenter.SignInPresenter;
import com.impvhc.apptwo.view.SignInView;

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

}
