package com.example.cobeosijek.myfirstandroidapp.training.fragments_example;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.cobeosijek.myfirstandroidapp.R;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        ExampleFragment exampleFragment = new ExampleFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_container, exampleFragment);
        fragmentTransaction.addToBackStack("transaction1");
        fragmentTransaction.commit();
    }
}
