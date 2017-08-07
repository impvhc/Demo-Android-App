package com.impvhc.apptwo.presenter;

import com.impvhc.apptwo.AppSharedPreferences;
import com.impvhc.apptwo.view.HomeView;

/**
 * Created by victor on 8/7/17.
 */

public class HomePresenter extends BasePresenter<Void,HomeView> {

    public HomePresenter(HomeView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        setEmail();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setEmail(){
        view.setEmail(AppSharedPreferences.getInstance().getEmail());
    }
}
