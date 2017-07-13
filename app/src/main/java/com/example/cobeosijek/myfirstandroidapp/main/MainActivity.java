package com.example.cobeosijek.myfirstandroidapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.CarUtils;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.main.cars_list.CarAdapter;
import com.example.cobeosijek.myfirstandroidapp.main.cars_list.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView email;
    private ImageView iconBack;
    private String passedEmail = Constants.EMPTY_TEXT;
    private CarAdapter carAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        getExtras();
        setData();
        setListener();

        setupItemsList();
        createCars();
    }

    private void setupItemsList() {
        carAdapter = new CarAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // uvijek mora grid(context, broj stupaca) i linear(context)
        recyclerView.setItemAnimator(new DefaultItemAnimator()); //moze i ne mora
        recyclerView.setAdapter(carAdapter); //uvijek adapter
    }

    private void createCars() {
        List<CarModel> cars = CarUtils.getAllCars();
        carAdapter.setItems(cars);
    }

    private void setData() {
        email.setText(passedEmail);
    }

    private void getExtras() {
        Intent intent = getIntent();
        passedEmail = intent.getStringExtra(Constants.EMAIL);
    }

    private void initUi() {
        email = (TextView) findViewById(R.id.email);
        iconBack = (ImageView) findViewById(R.id.icon_back);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setListener() {
        iconBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
