package com.tiunida.laundry0.ActivityForgetPass.Presenter;

import com.tiunida.laundry0.ActivityForgetPass.Interactor.ForgetPassInteractor;
import com.tiunida.laundry0.ActivityForgetPass.Interactor.ForgetPassInteractorMvp;
import com.tiunida.laundry0.ActivityForgetPass.View.ForgetPassViewMvp;
import com.tiunida.laundry0.ActivityForgetPass.events.ForgetPassEvents;
import com.tiunida.laundry0.EventBus.EventBus;
import com.tiunida.laundry0.EventBus.GreenRobotEventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiunida.laundry0.ActivityLogin.events.LoginEvent.onSignInError;

public class ForgetPassPresenter implements ForgetPassPresenterMvp {
    private ForgetPassInteractorMvp mForgetPassInteractorMvp;
    private ForgetPassViewMvp mForgetPassViewMvp;

    private EventBus mEventBus;

    public ForgetPassPresenter(ForgetPassViewMvp forgetPassViewMvp) {
        mForgetPassInteractorMvp = new ForgetPassInteractor();
        mForgetPassViewMvp = forgetPassViewMvp;
        mEventBus = GreenRobotEventBus.getInstance();
    }

    @Subscribe
    public void onEventMainThread(ForgetPassEvents event) {
        switch (event.getEventType()) {
            case ForgetPassEvents.onInputSuccess:
                onInputSucces();
                break;
            case ForgetPassEvents.onInputError:
                onInputError(event.getErrorMessage());
                break;
        }
    }

    private void onInputError(String error) {
        if (mForgetPassViewMvp != null) {
            mForgetPassViewMvp.showMessage(error);
        }
    }

    private void onInputSucces() {
        if (mForgetPassViewMvp != null) {
            mForgetPassViewMvp.showMessage("Silahkan periksa email antum");
            mForgetPassViewMvp.sendToLogin();
        }
    }

    @Override
    public void validateSendPasswordResetEmail(String email) {
        if (isValifForm(email)) {
            mForgetPassInteractorMvp.sendPasswordResetEmail(email);
        }
    }

    @Override
    public void onCreate() {
        mEventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mForgetPassViewMvp = null;
        mEventBus.unregister(this);
    }

    @Override
    public boolean isValifForm(String email) {
        boolean isValid = true;
        if (email.isEmpty()) {
            //String errorMessage = task.getException().getMessage();
            isValid = false;
            mForgetPassViewMvp.showMessage("Email kosong");
        }
        if (!isEmailValid(email)) {
            isValid = false;
            mForgetPassViewMvp.showMessage("Email tidak falid");
        }
        return isValid;
    }


    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
