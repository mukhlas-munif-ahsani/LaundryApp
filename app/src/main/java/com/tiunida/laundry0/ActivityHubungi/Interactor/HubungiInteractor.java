package com.tiunida.laundry0.ActivityHubungi.Interactor;

import com.tiunida.laundry0.ActivityHubungi.Model.HubungiRepository;
import com.tiunida.laundry0.ActivityHubungi.Model.HubungiRepositoryMvp;

public class HubungiInteractor implements HubungiInteractorMvp{
    private HubungiRepositoryMvp mHubungiRepositoryMvp;

    public HubungiInteractor(){
        mHubungiRepositoryMvp = new HubungiRepository();
    }

    public void getData(){
        mHubungiRepositoryMvp.getData();
    }
}
