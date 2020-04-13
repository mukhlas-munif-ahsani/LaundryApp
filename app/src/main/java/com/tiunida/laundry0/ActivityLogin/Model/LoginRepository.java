package com.tiunida.laundry0.ActivityLogin.Model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.tiunida.laundry0.ActivityLogin.Presenter.LoginPresenterMvp;
import com.tiunida.laundry0.EventBus.EventBus;
import com.tiunida.laundry0.EventBus.GreenRobotEventBus;
import com.tiunida.laundry0.ActivityLogin.events.LoginEvent;

import java.util.HashMap;
import java.util.Map;

public class LoginRepository implements LoginRepositoryMvp {
    private Context mContect;
    private FirebaseAuth mAuth;
    private String TAG = "LoginPresenter";
    private DatabaseReference mDatabase;
    private LoginPresenterMvp mLoginPresenterMvp;
    private FirebaseFirestore mFirestore;

    public LoginRepository() {
        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        //mLoginPresenterMvp = new LoginPresenter();
    }

    @Override
    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");

                            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                                @Override
                                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                    String token_id = task.getResult().getToken();
                                    String current_id = mAuth.getCurrentUser().getUid();

                                    Map<String, Object> tokenMap = new HashMap<>();
                                    tokenMap.put("token_id", token_id);

                                    mFirestore.collection("Users").document(current_id).update(tokenMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            postEvent(LoginEvent.onSignInSuccess);
                                        }
                                    });
                                }
                            });
                            //mLoginPresenterMvp.onSignInSuccess();
                        } else {
                            //dialog.dismiss();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(mContect, "email atau password anda tidak sesuai",
                                    //Toast.LENGTH_SHORT).show();
                            //postEvent(LoginEvent.onSignInError);
                            postEvent(LoginEvent.onSignInError);
                        }

                        // ...
                    }
                });
    }

    private void postEvent(int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null) {
            loginEvent.setErrorMessage(errorMessage);
        }
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }
}
