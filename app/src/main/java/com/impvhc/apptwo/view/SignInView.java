package com.impvhc.apptwo.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.impvhc.apptwo.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by victor on 8/6/17.
 */

public class SignInView extends ConstraintLayout{
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.email_et)
    EditText emailEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.email_til)
    TextInputLayout emailTil;
    @BindView(R.id.password_til)
    TextInputLayout passwordTil;
    @BindView(R.id.sign_up_tv)
    TextView signUpTv;

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());

    public SignInView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_sign_in, this);
        ButterKnife.bind(this);
        progressDialog.setMessage("Validating User");
    }

    public Observable<Void> getObservableNextBtn() {
        return RxView.clicks(nextBtn);
    }

    public Observable<Void> getObservableSignUp() {
        return RxView.clicks(signUpTv);
    }

    public Observable<CharSequence> getObservableEmail() {
        return RxTextView.textChanges(emailEt);
    }

    public Observable<CharSequence> getObservablePassword() {
        return RxTextView.textChanges(passwordEt);
    }

    public void errorEmailHandle(boolean status) {
        emailTil.setError("Invalid Email");
        emailTil.setErrorEnabled(!status);
    }

    public void errorPasswordHandle(boolean status) {
        passwordTil.setError("Invalid Password");
        passwordTil.setErrorEnabled(!status);
    }

    public void enableNextBtn(boolean value) {
        nextBtn.setEnabled(value);
    }

    public String getEmail() {
        return emailEt.getText().toString();
    }

    public String getPassword() {
        return passwordEt.getText().toString();
    }

    public void showLoading(boolean loading) {
        if (loading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }
}
