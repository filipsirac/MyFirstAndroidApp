package com.example.cobeosijek.myfirstandroidapp.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.R;

/**
 * Created by cobeosijek on 11/07/2017.
 */

public class ShowClassActivity extends AppCompatActivity {

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
        Intent intent = getIntent();

        passedEmail = intent.getStringExtra(Constants.EMAIL);
        passedGender = intent.getStringExtra(Constants.GENDER);
    }

    private void setData() {
        email.setText(passedEmail);
        gender.setText(passedGender);
    }
}
