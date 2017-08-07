package com.impvhc.apptwo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.impvhc.apptwo.R;
import com.impvhc.apptwo.presenter.HomePresenter;
import com.impvhc.apptwo.view.HomeView;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity {

    public static void start(Context context, Bundle bundle){
        Intent intent = new Intent(context,HomeActivity.class);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        BaseActivity.transitionLeft((Activity) context);
    }

    @Inject
    HomeView view;

    @Inject
    HomePresenter presenter;

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
