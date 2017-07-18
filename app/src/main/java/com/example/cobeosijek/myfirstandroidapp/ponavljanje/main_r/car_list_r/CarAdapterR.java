package com.example.cobeosijek.myfirstandroidapp.ponavljanje.main_r.car_list_r;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.main.cars_list.CarAdapter;
import com.example.cobeosijek.myfirstandroidapp.models.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/07/2017.
 */

public class CarAdapterR extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private final List<CarModel> carModelList = new ArrayList<>();
    private Context context;

    public void setItems(List<CarModel> items) {
        carModelList.clear();
        carModelList.addAll(items);
        notifyDataSetChanged();
    }

    public void addItems(List<CarModel> items) {
        carModelList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return carModelList.size();
    }

    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false);
        return new CarAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarAdapter.MyViewHolder holder, int position) {
        CarModel car = carModelList.get(position);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView carImage;
        private TextView name;
        private TextView age;
        private RelativeLayout carLayout;

        public ViewHolder(View view) {
            super(view);
            carImage= view.findViewById(R.id.car_image);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            carLayout = view.findViewById(R.id.car_layout);
        }
    }

}
