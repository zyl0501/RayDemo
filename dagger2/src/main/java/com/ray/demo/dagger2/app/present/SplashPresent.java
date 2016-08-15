package com.ray.demo.dagger2.app.present;

import javax.inject.Inject;

/**
 * Created by Ray on 16/3/8.
 */
public class SplashPresent {
    @Inject
    public SplashPresent(){}

    public int getSplashImgCount(){
        return 10;
    }
}
