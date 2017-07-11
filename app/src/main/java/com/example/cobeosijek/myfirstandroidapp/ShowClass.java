package com.example.cobeosijek.myfirstandroidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cobeosijek on 11/07/2017.
 */

public class ShowClass extends AppCompatActivity {

    private TextView email;
    private TextView gender;
    private String passedEmail = Constants.EMPTY_TEXT;
    private String passedGender = Constants.EMPTY_TEXT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);

        initUi();
        getExtras();
        setData();
    }

    public void initUi() {
        email = (TextView) findViewById(R.id.email);
        gender = (TextView) findViewById(R.id.gender);
    }

    private void getExtras() {
        passedEmail = getIntent().getStringExtra(Constants.EMAIL);
        passedGender = getIntent().getStringExtra(Constants.GENDER);
    }

    private void setData() {
        email.setText(passedEmail);
        gender.setText(passedGender);
    }
}
