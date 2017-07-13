package com.example.cobeosijek.myfirstandroidapp.training.fragments;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class FragmentCar {

    private String name;
    private String decription;

    public static final FragmentCar[] fragmentCars ={
        new FragmentCar("gdsd","2017\n 250kmh"),
        new FragmentCar("jaoi","2015\n 330kmh"),
        new FragmentCar("asdfa","2010\n 280kmh")
    };

    public FragmentCar(String name, String decription) {
        this.name = name;
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
