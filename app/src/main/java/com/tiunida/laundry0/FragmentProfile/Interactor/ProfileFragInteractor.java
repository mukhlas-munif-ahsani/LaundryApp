package com.tiunida.laundry0.FragmentProfile.Interactor;


import android.util.Log;

import com.tiunida.laundry0.FragmentProfile.Model.ProfileFragRepository;
import com.tiunida.laundry0.FragmentProfile.Model.ProfileFragRepositoryMvp;

public class ProfileFragInteractor implements ProfileFragInteractorMvp {
    private ProfileFragRepositoryMvp mProfileFragRepositoryMvp;
    public ProfileFragInteractor(){
        mProfileFragRepositoryMvp = new ProfileFragRepository();
    }

    public void getData(){
        mProfileFragRepositoryMvp.getProfileData();
        Log.d("interactor :","masuk");
    }
}
