package com.tiunida.laundry0.ActivityLogin.Presenter;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.tiunida.laundry0.ActivityLogin.Interactor.LoginInteractor;
import com.tiunida.laundry0.ActivityLogin.Interactor.LoginInteractorMvp;
import com.tiunida.laundry0.EventBus.EventBus;
import com.tiunida.laundry0.EventBus.GreenRobotEventBus;
import com.tiunida.laundry0.ActivityLogin.events.LoginEvent;
import com.tiunida.laundry0.ActivityLogin.View.LoginMvpView;

import org.greenrobot.eventbus.Subscribe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPresenter implements LoginPresenterMvp {

    private Context mContect;
    private FirebaseAuth mAuth;
    private String TAG = "LoginPresenter";;
    private DatabaseReference mDatabase;

    private EventBus mEventBus;
    private LoginMvpView mLoginMvpView;
    private LoginInteractorMvp mLoginInteractorMvp;

    public LoginPresenter(LoginMvpView loginMvpView) {
        mLoginMvpView = loginMvpView;
        mLoginInteractorMvp = new LoginInteractor();
        mEventBus = GreenRobotEventBus.getInstance();
//        this.mContect = mContect;
//        this.mAuth = mAuth;
//        this.mDatabase = mDatabase;
    }

    public LoginPresenter(LoginMvpView view, LoginInteractorMvp repository) {
        this.mLoginMvpView = view;
        this.mLoginInteractorMvp = repository;

        this.mLoginMvpView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        mEventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mLoginMvpView = null;
        mEventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event){
        switch (event.getEventType()){
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignInError:
                onSignInError();
                break;
        }
    }

    public void onSignInSuccess(){
        if (mLoginMvpView != null){
            mLoginMvpView.navigateToMainScreen();
        }
    }

    public void onSignInError(){
        if (mLoginMvpView != null){
            mLoginMvpView.hideProgress();
            mLoginMvpView.enableInputs();
            mLoginMvpView.showMessage("Email dan password tidak sesuai");
        }
    }

    @Override
    public boolean isValifForm(String email, String password) {
        boolean isValid = true;
        if (email.isEmpty()) {
            //String errorMessage = task.getException().getMessage();
            isValid = false;
            mLoginMvpView.showMessage("Email kosong");
        }
        if (!isEmailValid(email)) {
            isValid = false;
            mLoginMvpView.showMessage("Email tidak falid");
        }
        if (password.isEmpty()) {
            isValid = false;
            mLoginMvpView.showMessage("Password kosong");
        }
        return isValid;
    }

    @Override
    public void validateLogin(String email, String password){
        if (mLoginMvpView != null){
            mLoginMvpView.disableInputs();
            mLoginMvpView.showProgress();
        }
        mLoginInteractorMvp.doSignIn(email,password);
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
