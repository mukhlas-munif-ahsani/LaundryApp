package com.tiunida.laundry0.ActivitySaran.Interactor;

import com.tiunida.laundry0.ActivitySaran.Model.SaranRepository;
import com.tiunida.laundry0.ActivitySaran.Model.SaranRepositoryMvp;

public class SaranInteractor implements SaranInteractorMvp{
    private SaranRepositoryMvp mSaranRepositoryMvp;

    public SaranInteractor(){
        mSaranRepositoryMvp = new SaranRepository();
    }

    public void getData(){
        mSaranRepositoryMvp.getProfileData();
    }

    public void inputData(String name, String uniqId, String saran){
        mSaranRepositoryMvp.storeFirestore(name, uniqId, saran);
    }
}
