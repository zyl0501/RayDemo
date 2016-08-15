package com.ray.demo.dagger2.component.cdi.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zyl on 2016/6/23.
 */
@Module
public class ParentModule {
    @Provides
    @Named("parent_string")
    String provideString(){return "from parent module";}

    @Provides
    int provideInt(){return 23;}
}
