package com.example.cobeosijek.myfirstandroidapp.main.cars_list;

import java.util.List;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class CarModel {

    private List<String> images;
    private String name;
    private int age;

    public CarModel(List<String> images, String name, int age) {
        this.images = images;
        this.name = name;
        this.age = age;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
