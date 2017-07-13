package com.example.cobeosijek.myfirstandroidapp.training.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cobeosijek.myfirstandroidapp.R;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class TestFragment extends Fragment {

    private TextView name;
    private TextView description;
    private long menuId;

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public TestFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            menuId = savedInstanceState.getLong("menuId");
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null) {
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);

            FragmentCar menu= FragmentCar.fragmentCars[(int) menuId];

            name.setText(menu.getName());
            description.setText(menu.getDecription());
        }
    }
}
