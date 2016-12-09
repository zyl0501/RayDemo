package com.ray.demo.dagger2.component.cdi.module;

import android.app.Application;

import com.ray.demo.dagger2.app.HttpClient;
import com.ray.demo.dagger2.component.cdi.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ray on 16/3/8.
 */
@Module
public class AppModule {

    Application mApplication;
    HttpClient httpClient;

    public AppModule(Application application) {
        mApplication = application;
        httpClient = new HttpClient();
    }

    @Provides
    @AppScope
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @AppScope
    HttpClient providesHttpClient(){
        return httpClient;
    }
}
