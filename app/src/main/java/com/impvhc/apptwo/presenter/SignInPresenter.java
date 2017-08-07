package com.impvhc.apptwo.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.impvhc.apptwo.TwoApplication;
import com.impvhc.apptwo.activity.MainActivity;
import com.impvhc.apptwo.inject.activty.ActivityModule;
import com.impvhc.apptwo.util.TextUtil;
import com.impvhc.apptwo.util.ViewUtil;
import com.impvhc.apptwo.view.SignInView;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by victor on 8/6/17.
 */

public class SignInPresenter extends BasePresenter<Void,SignInView> {

    private final CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    Observable<CharSequence> emailObservable;
    Observable<CharSequence> passwordObservable;

    public SignInPresenter(SignInView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        emailObservable = view.getObservableEmail();
        passwordObservable = view.getObservablePassword();

        mCompositeSubscription.add(getSubscriptionNextBtn());
        mCompositeSubscription.add(getSubscriptionSignUpTv());
        mCompositeSubscription.add(getSubscriptionEnableNextBtn());
        mCompositeSubscription.add(getSubscriptionEmailErrorHandler());
        mCompositeSubscription.add(getSubscriptionPasswordErrorHandler());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private Subscription getSubscriptionNextBtn(){
        return view.getObservableNextBtn()
                .doOnNext(__ -> view.showLoading(true))
                .subscribe(__ -> {
                    ViewUtil.hideKeyboard(view.getContext(),view.getWindowToken());
                    MainActivity.start(view.getContext(),null);
                });
    }

    private Subscription getSubscriptionSignUpTv(){
        return view.getObservableSignUp()
                .subscribe(__ -> {
                    MainActivity.start(view.getContext(),null);
                });
    }

    public Subscription getSubscriptionEnableNextBtn(){
        return Observable.combineLatest(
                emailObservable,
                passwordObservable,
                (email,password) -> TextUtil.isEmailValid(email) && !TextUtils.isEmpty(password))
                .distinctUntilChanged()
                .subscribe(valid -> view.enableNextBtn(valid));
    }

    public Subscription getSubscriptionEmailErrorHandler(){
        return emailObservable
                .map(inputText -> (inputText.length() == 0) || TextUtil.isEmailValid(view.getEmail()))
                .distinctUntilChanged()
                .subscribe(isValid -> view.errorEmailHandle(isValid));
    }
    public Subscription getSubscriptionPasswordErrorHandler(){
        return passwordObservable
                .map(inputText -> (inputText.length() >= 0))
                .distinctUntilChanged()
                .subscribe(isValid -> view.errorPasswordHandle(isValid));
    }
}
