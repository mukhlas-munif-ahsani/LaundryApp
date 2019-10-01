package com.tiunida.laundry0.ActivityTentangAplikasi.Presenter;

public interface TentangAppPresenterMvp {
    void onCreate();
    void onDestroy();
    void getData();
    void onGetDataSuccess(String info);
}
