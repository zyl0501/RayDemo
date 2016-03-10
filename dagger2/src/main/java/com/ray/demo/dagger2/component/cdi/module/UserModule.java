package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.present.UserPresent;
import com.ray.demo.dagger2.component.cdi.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Named("1 arg")
    @Provides
    UserPresent userPresent2(String info) {
        return new UserPresent(info);
    }

    @Named("no arg")
    @PerActivity
    @Provides
    UserPresent userPresent(){
        return new UserPresent();
    }
    @Named("no arg")
    @Provides
    int integer(){
        return 12;
    }

    @Provides
    String getInfo() {
        return "User module generate info";
    }
}
