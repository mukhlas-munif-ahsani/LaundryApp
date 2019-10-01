package com.tiunida.laundry0.ActivityRegister.Interactor;

import com.tiunida.laundry0.ActivityRegister.Model.RegisterRepository;
import com.tiunida.laundry0.ActivityRegister.Model.RegisterRepositoryMvp;

public class RegisterInteractor implements RegisterInteractorMvp {

    private RegisterRepositoryMvp mRegisterRepositoryMvp;
    public RegisterInteractor(){
        mRegisterRepositoryMvp = new RegisterRepository();
    }

    @Override
    public void doSignUp(String email, String password){
        mRegisterRepositoryMvp.signUp(email, password);
    }

}
