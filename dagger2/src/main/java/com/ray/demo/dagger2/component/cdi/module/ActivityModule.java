package com.ray.demo.dagger2.component.cdi.module;

import android.app.Activity;

import com.ray.demo.dagger2.component.cdi.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    int provideInt() {
        return 99;
    }
}
