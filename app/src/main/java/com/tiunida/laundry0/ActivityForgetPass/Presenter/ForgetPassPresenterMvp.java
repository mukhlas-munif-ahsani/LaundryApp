package com.tiunida.laundry0.ActivityForgetPass.Presenter;

public interface ForgetPassPresenterMvp {
    void validateSendPasswordResetEmail(String email);
    void onCreate();
    void onDestroy();
    boolean isValifForm(String email);
}
