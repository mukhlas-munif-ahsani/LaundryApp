package com.tiunida.laundry0.ActivityEditProfile.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tiunida.laundry0.ActivitySetup.View.SetupActivity;
import com.tiunida.laundry0.R;
import com.tiunida.laundry0.ActivityEditProfile.Presenter.EditProfilePresenter;
import com.tiunida.laundry0.ActivityEditProfile.Presenter.EditProfilePresenterMvp;
import com.tiunida.laundry0.ActivityMain.MainActivity;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditProfileActivity extends AppCompatActivity implements EditProfileViewMvp {

    @BindView(R.id.text_input_name)
    TextInputLayout mTextInputName;
    @BindView(R.id.text_input_dormitory)
    TextInputLayout mTextInputDormitory;
    @BindView(R.id.text_input_room)
    TextInputLayout mTextInputRoom;
    @BindView(R.id.text_input_phone_number)
    TextInputLayout mTextInputPhoneNumber;
    @BindView(R.id.text_input_status)
    TextInputLayout mTextInputStatus;
    @BindView(R.id.text_input_gender)
    TextInputLayout mTextInputGender;

    @BindView(R.id.profile_name)
    TextInputEditText mProfileName;
    @BindView(R.id.dropdown_text)
    AutoCompleteTextView mDropdownDormitory;
    @BindView(R.id.profile_room)
    TextInputEditText mProfileRoom;
    @BindView(R.id.profile_phone_number)
    TextInputEditText mProfilePhone;
    @BindView(R.id.dropdown_text_status)
    AutoCompleteTextView mDropdownStatus;
    @BindView(R.id.dropdown_text_gender)
    AutoCompleteTextView mDropdownGender;
    @BindView(R.id.setup_progress)
    ProgressBar mSetupProgres;

    @BindView(R.id.setup_btn)
    Button mSaveBtn;

    private boolean isChanged = false;
    String status = "";
    String gender = "";
    String [] SPINNERLIST_STATUS={"Mahasiswa","Staff","Dosen","Tamu"};
    String [] SPINNERLIST_GENDER={"MALE","FEMALE"};

    private EditProfilePresenterMvp mEditProfilePresenterMvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

        mEditProfilePresenterMvp = new EditProfilePresenter(this);
        mEditProfilePresenterMvp.onCreate();

        getDataProfile();

        String[] dormitoryItems = new String[]{
                "Ustman bin Affan",
                "Abu Bakar",
                "Umar bin Khatab",
                "Ali bin Abi Thalib"
        };

        String[] statusItems = new String[]{
                "Mahasiswa",
                "Staff",
                "Dosen",
                "Tamu"
        };

        String[] genderItems = new String[]{
                "MALE",
                "FEMALE"
        };

        ArrayAdapter<String> dormitoryAdapter = new ArrayAdapter<>(
                EditProfileActivity.this,
                R.layout.dropdown_item_dormitory,
                dormitoryItems
        );

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(
                EditProfileActivity.this,
                R.layout.dropdown_item_status,
                statusItems
        );

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(
                EditProfileActivity.this,
                R.layout.dropdown_item_gender,
                genderItems
        );

        mDropdownDormitory.setAdapter(dormitoryAdapter);

        mDropdownStatus.setAdapter(statusAdapter);

        mDropdownGender.setAdapter(genderAdapter);

//        ArrayAdapter<String> arrayAdapterStatus = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,SPINNERLIST_STATUS);
//
//        mEditProfileStatus.setAdapter(arrayAdapterStatus);
//
//        mEditProfileStatus.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                status = mEditProfileStatus.getText().toString();
//            }
//        });
//
//        ArrayAdapter<String> arrayAdapterGender = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,SPINNERLIST_GENDER);
//
//        mEditProfileGender.setAdapter(arrayAdapterGender);
//
//        mEditProfileGender.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                gender = mEditProfileGender.getText().toString();
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        mEditProfilePresenterMvp.onDestroy();
        super.onDestroy();
    }

    public void getDataProfile(){
        mEditProfilePresenterMvp.getProfileData();
    }

    public void hideProgress(){
        mSetupProgres.setVisibility(View.INVISIBLE);
    }

    public void showProgress(){
        mSetupProgres.setVisibility(View.VISIBLE);
    }

    public void navigateToMainScreen(){
        Intent mainIntent = new Intent(EditProfileActivity.this, MainActivity.class);
        mainIntent.putExtra("tab2",2);
        startActivity(mainIntent);
        finish();
    }

    public void showMessage(String message){
        Toast.makeText(EditProfileActivity.this, message, Toast.LENGTH_LONG).show();
    }

    public void setInputs(boolean enabeled){
        mSaveBtn.setEnabled(enabeled);
        mDropdownGender.setEnabled(enabeled);
        mDropdownStatus.setEnabled(enabeled);
        mProfileName.setEnabled(enabeled);
        mDropdownDormitory.setEnabled(enabeled);
        mProfileRoom.setEnabled(enabeled);
        mProfilePhone.setEnabled(enabeled);
    }

    public void enableInputs(boolean enabeled){
        setInputs(true);
    }

    public void disableInputs(boolean enabeled){
        setInputs(false);
    }

    public void nameFieldError(String errorMsg){
        mTextInputName.setError(errorMsg);
    }

    public void nimFieldError(String errorMsg){
        //mEditProfileNim.setError(errorMsg);
    }

    public void dormitoryFieldError(String errorMsg){
        mTextInputDormitory.setError(errorMsg);
    }

    public void roomFieldError(String errorMsg){
        mTextInputRoom.setError(errorMsg);
    }

    public void phoneFieldError(String errorMsg){
        mTextInputPhoneNumber.setError(errorMsg);
    }

    @OnClick(R.id.setup_btn)
    public void saveInput(){
        final String user_name = mProfileName.getText().toString();
        //final String user_nim = mEditProfileNim.getText().toString();
        final String user_dormitory = mDropdownDormitory.getText().toString();
        final String user_room = mProfileRoom.getText().toString();
        final String user_phone = mProfilePhone.getText().toString();
        final String user_status = mDropdownStatus.getText().toString();
        final String user_gender = mDropdownGender.getText().toString();

        mEditProfilePresenterMvp.validateInput(user_name,user_dormitory,user_room,user_phone,user_gender,user_status);
    }

    public void setData(String dataName, String dataDormitory, String dataRoom, String dataPhone, String dataStatus, String dataGender){
        mProfileName.setText(dataName);
       // mEditProfileNim.setText(dataNim);
        mDropdownDormitory.setText(dataDormitory);
        mProfileRoom.setText(dataRoom);
        mProfilePhone.setText(dataPhone);
        mDropdownStatus.setText(dataStatus);
        mDropdownGender.setText(dataGender);
    }

}
