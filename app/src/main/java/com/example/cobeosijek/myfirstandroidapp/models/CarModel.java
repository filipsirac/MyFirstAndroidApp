package com.example.cobeosijek.myfirstandroidapp.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class CarModel implements Serializable {

    private List<String> images;
    private String name;
    private int age;
    private int speed;
    private String registration;

    public CarModel(List<String> images, String name, int age, int speed, String registration) {
        this.images = images;
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.registration = registration;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
