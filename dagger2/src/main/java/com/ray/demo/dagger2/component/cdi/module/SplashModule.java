package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.present.SplashPresent;

import javax.inject.Named;

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

    @Provides
    @Named("sub")
    String provideString(){
        return "from Splash Module";
    }

    @Provides
    long provideLong(){
        return 99999999999999L;
    }

    @Provides
    @Named("sub2")
    String provideMergeStr(int i){
        return "from Splash Module merge and "+ i;
    }
}
