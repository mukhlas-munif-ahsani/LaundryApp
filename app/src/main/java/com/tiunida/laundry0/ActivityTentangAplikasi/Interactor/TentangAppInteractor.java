package com.tiunida.laundry0.ActivityTentangAplikasi.Interactor;

import com.tiunida.laundry0.ActivityTentangAplikasi.Model.TentangAppRepository;
import com.tiunida.laundry0.ActivityTentangAplikasi.Model.TentangAppRepositoryMvp;

public class TentangAppInteractor implements TentangAppInteractorMvp {
    private TentangAppRepositoryMvp mTentangAppRepositoryMvp;

    public TentangAppInteractor(){
        mTentangAppRepositoryMvp = new TentangAppRepository();
    }

    public void getData(){
        mTentangAppRepositoryMvp.getInfoData();
    }
}
