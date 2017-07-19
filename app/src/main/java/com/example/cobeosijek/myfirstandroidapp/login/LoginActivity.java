package com.example.cobeosijek.myfirstandroidapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.ErrorCheck;
import com.example.cobeosijek.myfirstandroidapp.main.MainActivity;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button login;
    private String emailText;
    private String passwordText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUi();
        setListener();
    }

    private void initUi() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
    }

    private void setListener() {
        login.setOnClickListener(this);
    }

    private boolean isFormValid() {
        boolean isEmailValid;
        boolean isPasswordValid;

        if (!ErrorCheck.isValidEmail(emailText)) {
            isEmailValid = false;
            email.setError(getString(R.string.email_validation));
        } else {
            isEmailValid = true;
        }


        if (!ErrorCheck.isValidPassword(passwordText)) {
            isPasswordValid = false;
            password.setError(getString(R.string.password_validation));
        } else {
            isPasswordValid = true;
        }

        return isEmailValid && isPasswordValid;
    }

    private void getData() {
        emailText = email.getText().toString();
        passwordText = password.getText().toString();
    }

    @Override
    public void onClick(View view) {
        getData();
        if (isFormValid()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(Constants.EMAIL, emailText);
            startActivity(intent);
        }
    }
}
