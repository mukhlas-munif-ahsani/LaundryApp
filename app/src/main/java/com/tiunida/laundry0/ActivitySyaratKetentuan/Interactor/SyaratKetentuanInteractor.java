package com.tiunida.laundry0.ActivitySyaratKetentuan.Interactor;

import com.tiunida.laundry0.ActivitySyaratKetentuan.Model.SyaratKetentuanRepository;
import com.tiunida.laundry0.ActivitySyaratKetentuan.Model.SyaratKetentuanRepositoryMvp;

public class SyaratKetentuanInteractor implements SyaratKetentuanInteractorMvp {
    SyaratKetentuanRepositoryMvp mSyaratKetentuanRepositoryMvp;

    public SyaratKetentuanInteractor(){
        mSyaratKetentuanRepositoryMvp = new SyaratKetentuanRepository();
    }

    public void getData(){
        mSyaratKetentuanRepositoryMvp.getData();
    }
}
