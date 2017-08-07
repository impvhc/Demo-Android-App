package com.impvhc.apptwo.presenter;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;

import com.impvhc.apptwo.AppSharedPreferences;
import com.impvhc.apptwo.TwoApplication;
import com.impvhc.apptwo.activity.BaseActivity;
import com.impvhc.apptwo.activity.HomeActivity;
import com.impvhc.apptwo.activity.SignInActivity;
import com.impvhc.apptwo.inject.activty.ActivityModule;
import com.impvhc.apptwo.view.SplashView;

import javax.inject.Inject;

/**
 * Created by victor on 8/7/17.
 */

public class SplashPresenter extends BasePresenter<Void,SplashView> {

    @Inject
    AppSharedPreferences appSharedPreferences;

    public SplashPresenter(SplashView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        TwoApplication.get().getComponent().plus(new ActivityModule(view.getContext())).inject(this);
        checkFlow();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void checkFlow(){
        new Handler().postDelayed(() -> {
            if(!TextUtils.isEmpty(appSharedPreferences.getEmail()))
                HomeActivity.start(view.getContext(),null);
            else
                SignInActivity.start(view.getContext(),null);
            BaseActivity.finish((Activity) view.getContext());
        },1500);
    }
}
