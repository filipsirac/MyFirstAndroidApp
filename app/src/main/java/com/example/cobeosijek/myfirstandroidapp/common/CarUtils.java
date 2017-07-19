package com.example.cobeosijek.myfirstandroidapp.common;

import com.example.cobeosijek.myfirstandroidapp.models.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 13/07/2017.
 */

public class CarUtils {

    public static List<CarModel> getAllCars() {
        List<CarModel> cars = new ArrayList<>();

        List<String> audiImages = new ArrayList<>();
        audiImages.add("https://4.bp.blogspot.com/-p6VBxTJh38k/WNkAJDguMhI/AAAAAAAAYoI/Ug0ER0kGwPQoS-6gfqJc3Czv1AGlCAlfgCLcB/s1600/a8-rendering.jpg");
        audiImages.add("http://images.financialexpress.com/2017/07/AudiA8_main.jpg");
        audiImages.add("https://www.netcarshow.com/Audi-A8-2018-1600-0d.jpg");
        audiImages.add("http://media.caranddriver.com/images/media/51/2017-audi-s8-plus-inline2-photo-672070-s-original.jpg");

        List<String> bmwImages = new ArrayList<>();
        bmwImages.add("https://media.ed.edmunds-media.com/bmw/7-series/2016/oem/2016_bmw_7-series_sedan_750i-xdrive_fq_oem_4_1280.jpg");
        bmwImages.add("http://st.motortrend.com/uploads/sites/5/2015/11/2016-BMW-750i-xDrive-cockpit.jpg");
        bmwImages.add("https://s-media-cache-ak0.pinimg.com/originals/a1/7a/d1/a17ad18b4ee4837f401a9a2c3dd198b0.jpg");

        List<String> porscheImages = new ArrayList<>();
        porscheImages.add("http://files2.porsche.com/filestore/image/multimedia/none/991-2nd-tus-exc-detail-highlight-exterior-xle/zoom/d9b69840-3a1c-11e7-9f74-0019999cd470;s3/porsche-zoom.jpg");
        porscheImages.add("http://hanabi.autoweek.com/sites/default/files/styles/gen-1200-675/public/18953363_10155726606922668_.jpg?itok=UoNrhtKF");
        porscheImages.add("http://st.automobilemag.com/uploads/sites/11/2017/06/Porsche-911-Turbo-S-Exclusive-Series-Interior.jpg");
        porscheImages.add("http://st.motortrend.com/uploads/sites/10/2016/11/2017-Porsche-911-Turbo-S-Cabriolet-interior.jpg");
        porscheImages.add("http://files2.porsche.com/filestore/image/multimedia/none/991-2nd-tus-exc-detail-highlight-interior-xle/preview/4088bd00-3a1d-11e7-9f74-0019999cd470/porsche-preview.jpg");

        cars.add(new CarModel(audiImages, "Audi A8", 2018, 330, "OS-675-AB"));
        cars.add(new CarModel(bmwImages, "Bmw 750i", 2017, 280, "OS-111-CC"));
        cars.add(new CarModel(porscheImages, "Porsche 911 turbo S", 2017, 350, "ZG-222-FF"));
        return cars;
    }

    public static List<CarModel> getFavouriteCars() {
        List<CarModel> cars = new ArrayList<>();

        List<String> porscheImages = new ArrayList<>();
        porscheImages.add("http://files2.porsche.com/filestore/image/multimedia/none/991-2nd-tus-exc-detail-highlight-exterior-xle/zoom/d9b69840-3a1c-11e7-9f74-0019999cd470;s3/porsche-zoom.jpg");
        porscheImages.add("http://hanabi.autoweek.com/sites/default/files/styles/gen-1200-675/public/18953363_10155726606922668_.jpg?itok=UoNrhtKF");
        porscheImages.add("http://st.automobilemag.com/uploads/sites/11/2017/06/Porsche-911-Turbo-S-Exclusive-Series-Interior.jpg");
        porscheImages.add("http://st.motortrend.com/uploads/sites/10/2016/11/2017-Porsche-911-Turbo-S-Cabriolet-interior.jpg");
        porscheImages.add("http://files2.porsche.com/filestore/image/multimedia/none/991-2nd-tus-exc-detail-highlight-interior-xle/preview/4088bd00-3a1d-11e7-9f74-0019999cd470/porsche-preview.jpg");

        cars.add(new CarModel(porscheImages, "Porsche 911 turbo S", 2017, 350, "ZG-222-FF"));
        return cars;
    }
}
