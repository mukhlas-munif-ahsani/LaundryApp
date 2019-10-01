package com.tiunida.laundry0.ActivitySaran.Presenter;

public interface SaranPresenterMvp {
    void onInputSuccess();
    void onGetDataSuccess(String name);
    void onCreate();
    void onDestroy();
    void getData();
    void validateInputs(String name, String uniqId, String saran);
}
