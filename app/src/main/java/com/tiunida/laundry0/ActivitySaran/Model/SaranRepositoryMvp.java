package com.tiunida.laundry0.ActivitySaran.Model;

public interface SaranRepositoryMvp {
    void getProfileData();
    void storeFirestore(String name, String uniqId, String saran);
    void postEvent(int type, String errorMessage, String dataName);
    void postEvent(int type, String errorMessage);
    void postEvent(int type);
}
