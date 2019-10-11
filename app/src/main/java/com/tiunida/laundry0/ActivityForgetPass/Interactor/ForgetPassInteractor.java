package com.tiunida.laundry0.ActivityForgetPass.Interactor;

import com.tiunida.laundry0.ActivityForgetPass.Model.ForgetPassRepository;
import com.tiunida.laundry0.ActivityForgetPass.Model.ForgetPassRepositoryMvp;

public class ForgetPassInteractor implements ForgetPassInteractorMvp {
    private ForgetPassRepositoryMvp mForgetPassRepositoryMvp;

    public ForgetPassInteractor(){
        mForgetPassRepositoryMvp = new ForgetPassRepository();
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        mForgetPassRepositoryMvp.sendPasswordResetEmail(email);
    }
}
