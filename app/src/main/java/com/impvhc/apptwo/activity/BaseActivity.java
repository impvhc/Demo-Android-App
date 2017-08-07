package com.impvhc.apptwo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.impvhc.apptwo.TwoApplication;
import com.impvhc.apptwo.inject.activty.ActivityComponent;
import com.impvhc.apptwo.inject.activty.ActivityModule;

/**
 * Created by victor on 8/6/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getComponent(Activity activity){
        return TwoApplication.get(this)
                .getComponent()
                .plus(new ActivityModule(activity));
    }
}
