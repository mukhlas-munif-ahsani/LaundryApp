package com.tiunida.laundry0.ActivityHubungi.Model;

public interface HubungiRepositoryMvp {
    void postEvent(int type, String errorMessage, String no, String desc, String email);
    void getData();
}
