package com.example.cobeosijek.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by cobeosijek on 11/07/2017.
 */

public class LoginActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private EditText email;
    private Button registration;

    private RadioGroup radioGroup;
    private String emailText;
    private String genderText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUi();
        setListeners();
        genderText = getString(R.string.male);
    }

    private void getEmail() {
        emailText = email.getText().toString();
    }

    public void initUi() {
        email = (EditText) findViewById(R.id.email);
        radioGroup = (RadioGroup) findViewById(R.id.gender_group);
        registration = (Button) findViewById(R.id.registration);
    }

    private void setListeners() {
        registration.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        RadioButton checkedButton = (RadioButton) findViewById(checkedId);
        genderText = checkedButton.getText().toString();
    }

    @Override
    public void onClick(View view) {
        getEmail();
        Intent intent = new Intent(getApplicationContext(), ShowClass.class);
        intent.putExtra(Constants.EMAIL, emailText);
        intent.putExtra(Constants.GENDER, genderText);
        startActivity(intent);
    }
}
