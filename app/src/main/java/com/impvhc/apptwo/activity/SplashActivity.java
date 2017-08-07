package com.impvhc.apptwo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.impvhc.apptwo.R;
import com.impvhc.apptwo.presenter.SplashPresenter;
import com.impvhc.apptwo.view.SplashView;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject
    SplashView view;

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(this).inject(this);
        setContentView(R.layout.activity_splash);
        presenter.onCreate();
    }
}
