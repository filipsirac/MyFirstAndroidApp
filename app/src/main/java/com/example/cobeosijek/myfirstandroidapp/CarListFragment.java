package com.example.cobeosijek.myfirstandroidapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.training.fragments.FragmentCar;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarListFragment extends ListFragment {

    public static interface CarListListener {
        void itemClicked(long id);

    }

    public CarListFragment() {
        // Required empty public constructor
    }

    private CarListListener carListListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.carListListener = (CarListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(carListListener!=null){
            carListListener.itemClicked(id);
        }
        super.onListItemClick(l, v, position, id);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String names[] = new String[FragmentCar.fragmentCars.length];

        for (int i = 0; i < names.length; i++) {
            names[i] = FragmentCar.fragmentCars[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
