package com.tiunida.laundry0.ActivityLogin.View;

import com.tiunida.laundry0.ActivityLogin.Presenter.LoginPresenter;

public interface LoginMvpView{

    void showProgress();
    void hideProgress();
    void enableInputs();
    void disableInputs();
    void navigateToMainScreen();
    void handleSignIn();
    void navigateToRegisterScreen();
    void navigateToForgetPassScreen();
    void showMessage(String message);

    void setPresenter(LoginPresenter loginPresenter);
}
