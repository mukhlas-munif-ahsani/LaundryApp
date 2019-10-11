package com.tiunida.laundry0.ActivityForgetPass.Model;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.tiunida.laundry0.ActivityForgetPass.events.ForgetPassEvents;
import com.tiunida.laundry0.EventBus.EventBus;
import com.tiunida.laundry0.EventBus.GreenRobotEventBus;

public class ForgetPassRepository implements ForgetPassRepositoryMvp {

    FirebaseAuth firebaseAuth;

    public ForgetPassRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
//                    Toast.makeText(ForgetPassActivity.this, "Silahkan priksa E-mail anda", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(ForgetPassActivity.this, LoginActivity.class);
//                    startActivity(intent);
                    postEvent(ForgetPassEvents.onInputSuccess);
                } else {
//                    Toast.makeText(ForgetPassActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    postEvent(ForgetPassEvents.onInputError, task.getException().getMessage());
                }
            }
        });
    }

    private void postEvent(int type, String errorMessage) {
        ForgetPassEvents forgetPassEvents = new ForgetPassEvents();
        forgetPassEvents.setEventType(type);
        if (errorMessage != null) {
            forgetPassEvents.setErrorMessage(errorMessage);
        }
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(forgetPassEvents);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }
}
