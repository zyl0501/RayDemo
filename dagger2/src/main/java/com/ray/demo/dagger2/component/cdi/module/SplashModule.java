package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.present.SplashPresent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ray on 16/3/8.
 */
@Module
public class SplashModule {
    @Provides
    SplashPresent splash(){
        return new  SplashPresent();
    }
}
