package com.example.cobeosijek.myfirstandroidapp.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.main.cars_pager.CarsPagerAdapter;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView email;
    private ImageView iconBack;
    private String passedEmail = Constants.EMPTY_TEXT;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView iconPerson;
    private TextView home;
    private ViewGroup rootLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        getExtras();
        setData();
        setListener();
        setViewPager();
    }

    private void initUi() {
        email = (TextView) findViewById(R.id.email);
        iconBack = (ImageView) findViewById(R.id.icon_back);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        iconPerson = (ImageView) findViewById(R.id.icon_person);
        home = (TextView) findViewById(R.id.home);
        rootLayout = (ViewGroup) findViewById(R.id.root_layout);
    }

    private void getExtras() {
        Intent intent = getIntent();
        passedEmail = intent.getStringExtra(Constants.EMAIL);
    }

    private void setData() {
        if (passedEmail != null) {
            email.setText(passedEmail);
        }
    }

    private void setListener() {
        iconBack.setOnClickListener(this);
        iconPerson.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    private void setViewPager() {
        CarsPagerAdapter carsPagerAdapter = new CarsPagerAdapter(getSupportFragmentManager());
        carsPagerAdapter.addFragment(CarsFragment.newInstance(Constants.ALL_CARS), getString(R.string.all_cars));
        carsPagerAdapter.addFragment(CarsFragment.newInstance(Constants.FAVOURITE_CARS), getString(R.string.favourite_cars));
        viewPager.setAdapter(carsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_back:
                finish();
                break;
            case R.id.icon_person:
                openAlertDialog();
                break;
            case R.id.home:
                showSnackBar();
                break;
        }
    }

    private void openAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.set_title));
        alertDialog.setMessage(getString(R.string.set_message));
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        showToast(getString(R.string.clicked_no));
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        showToast(getString(R.string.clicked_yes));
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showSnackBar() {
        Snackbar.make(rootLayout, getString(R.string.snackbar_message), Snackbar.LENGTH_SHORT).show();
    }

}
