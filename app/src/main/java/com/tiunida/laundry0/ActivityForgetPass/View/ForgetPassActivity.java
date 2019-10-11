package com.tiunida.laundry0.ActivityForgetPass.View;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.tiunida.laundry0.ActivityForgetPass.Presenter.ForgetPassPresenter;
import com.tiunida.laundry0.ActivityForgetPass.Presenter.ForgetPassPresenterMvp;
import com.tiunida.laundry0.R;
import com.tiunida.laundry0.ActivityLogin.View.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPassActivity extends AppCompatActivity implements ForgetPassViewMvp {


    @BindView(R.id.send_email)
    Button mSendBtn;
    @BindView(R.id.forget_email)
    EditText mForgetEmailEdt;
    FirebaseAuth firebaseAuth;

    private ForgetPassPresenterMvp mForgetPassPresenterMvp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        ButterKnife.bind(this);

        mForgetPassPresenterMvp = new ForgetPassPresenter(this);
        mForgetPassPresenterMvp.onCreate();

//        firebaseAuth = FirebaseAuth.getInstance();

//        mSendBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.sendPasswordResetEmail(mForgetEmailEdt.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(ForgetPassActivity.this, "Silahkan priksa E-mail anda", Toast.LENGTH_LONG).show();
//
//                        } else {
//                            Toast.makeText(ForgetPassActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        mForgetPassPresenterMvp.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showMessage(String txt) {
        Toast.makeText(ForgetPassActivity.this, txt, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendToLogin() {
        Intent intent = new Intent(ForgetPassActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.send_email)
    public void onSendEmailBtnOnClick(){
        mForgetPassPresenterMvp.validateSendPasswordResetEmail(mForgetEmailEdt.getText().toString());
    }
}
