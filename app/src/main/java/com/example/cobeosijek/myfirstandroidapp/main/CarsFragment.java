package com.example.cobeosijek.myfirstandroidapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.CarUtils;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.main.cars_list.CarAdapter;
import com.example.cobeosijek.myfirstandroidapp.models.CarModel;

import java.util.List;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class CarsFragment extends Fragment {

    private CarAdapter carAdapter;
    private RecyclerView recyclerView;

    public static CarsFragment newInstance(String carsType) {
        CarsFragment carsFragment = new CarsFragment();
        Bundle extras = new Bundle();
        extras.putString(Constants.CAR_TYPE, carsType);
        carsFragment.setArguments(extras);
        return carsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cars, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUi(view);
        setAdapter();
        getExtras();
    }

    private void initUi(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    private void setAdapter() {
        carAdapter = new CarAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // uvijek mora grid(context, broj stupaca) i linear(context)
        recyclerView.setItemAnimator(new DefaultItemAnimator()); //moze i ne mora
        recyclerView.setAdapter(carAdapter); //uvijek adapter
    }

    private void getExtras() {
        Bundle bundle = getArguments();
        String carType = bundle.getString(Constants.CAR_TYPE);
        if (carType != null) {
            List<CarModel> cars;
            if (carType.equals(Constants.ALL_CARS)) {
                cars = CarUtils.getAllCars();
                carAdapter.setItems(cars);
            } else if (carType.equals(Constants.FAVOURITE_CARS)) {
                cars = CarUtils.getFavouriteCars();
                carAdapter.setItems(cars);

            }
        }
    }

}
