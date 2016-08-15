package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.component.cdi.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ray on 16/3/8.
 */
@Module
@PerActivity
public class ChildModule {

    @Provides
    @Named("sub2")
//    @PerUser
    String provideMergeStr(int i){
        return "from Splash Module merge and "+ i;
    }

    @Provides
    @Named("sub3")
    @PerActivity
    String provideMergeStr3(){
        return "sub 3";
    }
}
