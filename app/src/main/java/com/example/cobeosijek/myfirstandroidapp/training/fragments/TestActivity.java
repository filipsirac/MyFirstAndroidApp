package com.example.cobeosijek.myfirstandroidapp.training.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.cobeosijek.myfirstandroidapp.CarListFragment;
import com.example.cobeosijek.myfirstandroidapp.R;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class TestActivity extends AppCompatActivity implements CarListFragment.CarListListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }


    @Override
    public void itemClicked(long id) {
        TestFragment details=new TestFragment();
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        details.setMenuId(id);
        fragmentTransaction.replace(R.id.fragment_container, details);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
