package com.example.cobeosijek.myfirstandroidapp.main.cars_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;
import com.example.cobeosijek.myfirstandroidapp.common.Constants;
import com.example.cobeosijek.myfirstandroidapp.details.CarDetailsActivity;
import com.example.cobeosijek.myfirstandroidapp.models.CarModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private final List<CarModel> carList = new ArrayList<>(); //moguci itemi
    private Context context;

    public void setItems(List<CarModel> items) {
        carList.clear();
        carList.addAll(items);
        notifyDataSetChanged();
    }

    public void addItems(List<CarModel> items) {
        carList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final CarModel car = carList.get(position);

        holder.name.setText(car.getName());
        holder.age.setText(String.format(Locale.getDefault(), context.getString(R.string.age_format), car.getAge()));

        if (car.getImages() != null && !car.getImages().isEmpty()) {
            Picasso.with(context).load(car.getImages().get(0)).into(holder.carImage);
        }

        holder.carLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CarDetailsActivity.class);
                intent.putExtra(Constants.CAR_MODEL, car);
                context.startActivity(intent);
            }
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView carImage;
        private TextView name;
        private TextView age;
        private RelativeLayout carLayout;

        public MyViewHolder(View view) {
            super(view);
            carImage = view.findViewById(R.id.car_image);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            carLayout = view.findViewById(R.id.car_layout);
        }
    }
}
