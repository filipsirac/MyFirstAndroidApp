package com.example.cobeosijek.myfirstandroidapp.ponavljanje.main_r.car_list_r;

import java.util.List;

/**
 * Created by cobeosijek on 17/07/2017.
 */

public class CarModelR {

    private List<String> images;
    private String name;
    private int ages;

    public CarModelR(List<String> images, String name, int ages) {
        this.images = images;
        this.name = name;
        this.ages = ages;
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

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

}
