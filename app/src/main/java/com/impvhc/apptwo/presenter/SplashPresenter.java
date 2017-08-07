package com.impvhc.apptwo.presenter;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;

import com.impvhc.apptwo.AppSharedPreferences;
import com.impvhc.apptwo.activity.BaseActivity;
import com.impvhc.apptwo.activity.HomeActivity;
import com.impvhc.apptwo.activity.SignInActivity;
import com.impvhc.apptwo.view.SplashView;

/**
 * Created by victor on 8/7/17.
 */

public class SplashPresenter extends BasePresenter<Void,SplashView> {
    AppSharedPreferences appSharedPreferences;

    public SplashPresenter(SplashView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        appSharedPreferences = AppSharedPreferences.getInstance();
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
