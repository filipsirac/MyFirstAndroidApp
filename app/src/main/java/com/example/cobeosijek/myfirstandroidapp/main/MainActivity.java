package com.example.cobeosijek.myfirstandroidapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
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
        setContentView(R.layout.main_activity);

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
        List<CarModel> cars = new ArrayList<>();
        List<String> audiImages = new ArrayList<>();
        audiImages.add("https://4.bp.blogspot.com/-p6VBxTJh38k/WNkAJDguMhI/AAAAAAAAYoI/Ug0ER0kGwPQoS-6gfqJc3Czv1AGlCAlfgCLcB/s1600/a8-rendering.jpg");
        audiImages.add("http://images.financialexpress.com/2017/07/AudiA8_main.jpg");
        audiImages.add("https://www.netcarshow.com/Audi-A8-2018-1600-0d.jpg");
        List<String> bmwImages = new ArrayList<>();
        bmwImages.add("https://media.ed.edmunds-media.com/bmw/7-series/2016/oem/2016_bmw_7-series_sedan_750i-xdrive_fq_oem_4_1280.jpg");
        bmwImages.add("http://st.motortrend.com/uploads/sites/5/2015/11/2016-BMW-750i-xDrive-cockpit.jpg");
        List<String> porscheImages = new ArrayList<>();
        porscheImages.add("http://files2.porsche.com/filestore/image/multimedia/none/991-2nd-tus-exc-detail-highlight-exterior-xle/zoom/d9b69840-3a1c-11e7-9f74-0019999cd470;s3/porsche-zoom.jpg");
        porscheImages.add("http://hanabi.autoweek.com/sites/default/files/styles/gen-1200-675/public/18953363_10155726606922668_.jpg?itok=UoNrhtKF");

        cars.add(new CarModel(audiImages, "Audi A8", 2018));
        cars.add(new CarModel(bmwImages, "Bmw 750i", 2017));
        cars.add(new CarModel(porscheImages, "Porsche 911 turbo S", 2017));

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