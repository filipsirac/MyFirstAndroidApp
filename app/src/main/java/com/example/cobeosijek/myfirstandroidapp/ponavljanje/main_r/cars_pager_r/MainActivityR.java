package com.example.cobeosijek.myfirstandroidapp.ponavljanje.main_r.cars_pager_r;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.main.CarsFragment;
import com.example.cobeosijek.myfirstandroidapp.main.cars_pager.CarsPagerAdapter;

/**
 * Created by cobeosijek on 17/07/2017.
 */

public class MainActivityR extends AppCompatActivity implements View.OnClickListener {

    private TextView email;
    private ImageView iconBack;
    private String passedEmail = Constants.EMPTY_TEXT;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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

    private void setData() {
        email.setText(passedEmail);
    }

    private void getExtras() {
        Intent intent = getIntent();
        passedEmail = intent.getStringExtra(Constants.EMAIL);
    }

    private void setListener() {
        iconBack.setOnClickListener(this);
    }

    private void initUi() {
        email = (TextView) findViewById(R.id.email);
        iconBack = (ImageView) findViewById(R.id.icon_back);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
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
        finish();
    }
}
