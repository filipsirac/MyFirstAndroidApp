package com.example.cobeosijek.myfirstandroidapp.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.models.CarModel;

import java.util.List;
import java.util.Locale;

/**
 * Created by cobeosijek on 18/07/2017.
 */

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TextView age;
    private TextView model;
    private TextView speed;
    private TextView registration;
    private ImageView iconBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initUi();
        setListeners();
        getExtras();
    }

    private void initUi() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        age = (TextView) findViewById(R.id.passed_age);
        model = (TextView) findViewById(R.id.passed_name);
        speed = (TextView) findViewById(R.id.passed_speed);
        registration = (TextView) findViewById(R.id.passed_registration);
        iconBack = (ImageView) findViewById(R.id.icon_back);
    }

    private void setListeners() {
        iconBack.setOnClickListener(this);
    }

    private void getExtras() {
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        CarModel carModel = (CarModel) bundle.getSerializable(Constants.CAR_MODEL);
        if (carModel != null) {
            showCarDetails(carModel);
        }
    }

    private void showCarDetails(CarModel carModel) {
        model.setText(carModel.getName());
        speed.setText(String.format(Locale.getDefault(), getString(R.string.speed_format), carModel.getSpeed()));
        age.setText(String.format(Locale.getDefault(), getString(R.string.age_format), carModel.getAge()));
        registration.setText(String.format(Locale.getDefault(), getString(R.string.registration_format), carModel.getRegistration()));
        setImagesAdapter(carModel.getImages());

    }

    private void setImagesAdapter(List<String> images) {
        ImagePagerAdapter adapter = new ImagePagerAdapter(this);
        adapter.setImages(images);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
