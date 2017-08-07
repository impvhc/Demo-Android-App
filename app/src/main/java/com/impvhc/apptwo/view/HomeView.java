package com.impvhc.apptwo.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;

import com.impvhc.apptwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victor on 8/7/17.
 */

public class HomeView extends ConstraintLayout {
    @BindView(R.id.email_tv)
    TextView emailTv;

    public HomeView(Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_home, this);
        ButterKnife.bind(this);
    }

    public void setEmail(String email){
        emailTv.setText(email);
    }
}
