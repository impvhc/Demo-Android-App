package com.impvhc.apptwo.presenter;

import com.impvhc.apptwo.AppSharedPreferences;
import com.impvhc.apptwo.TwoApplication;
import com.impvhc.apptwo.inject.activty.ActivityModule;
import com.impvhc.apptwo.view.HomeView;

import javax.inject.Inject;

/**
 * Created by victor on 8/7/17.
 */

public class HomePresenter extends BasePresenter<Void,HomeView> {

    @Inject
    AppSharedPreferences appSharedPreferences;

    public HomePresenter(HomeView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        TwoApplication.get().getComponent().plus(new ActivityModule(view.getContext())).inject(this);
        setEmail();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setEmail(){
        view.setEmail(appSharedPreferences.getEmail());
    }
}
