package com.tiunida.laundry0;

import com.google.common.base.Verify;
import com.tiunida.laundry0.ActivityLogin.Interactor.LoginInteractor;
import com.tiunida.laundry0.ActivityLogin.Interactor.LoginInteractorMvp;
import com.tiunida.laundry0.ActivityLogin.Presenter.LoginPresenter;
import com.tiunida.laundry0.ActivityLogin.View.LoginMvpView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class ActivityLoginPresenterTest {

    @Mock
    LoginInteractorMvp interactorMvp;
    @Mock
    LoginMvpView view;
    private LoginPresenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        presenter = new LoginPresenter(view);


    }

    @Test
    public void validateLoginTest(){
        String email = "munifahsan@gmail.com";
        String password = "mb47626cg";
        presenter.validateLogin(email, password);
        verify(view, never()).disableInputs();
        verify(interactorMvp, never()).doSignIn(anyString(), anyString());
    }
}
