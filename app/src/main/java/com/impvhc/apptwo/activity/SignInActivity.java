package com.impvhc.apptwo.activity;

import android.os.Bundle;
import android.util.Log;

import com.impvhc.apptwo.presenter.SignInPresenter;
import com.impvhc.apptwo.view.SignInView;

import javax.inject.Inject;

public class SignInActivity extends BaseActivity {

    @Inject
    SignInView view;

    @Inject
    SignInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(this).inject(this);
        setContentView(view);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
