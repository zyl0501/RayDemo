package com.ray.demo;

import android.app.Application;

/**
 * Created by Ray on 16/2/16.
 */
public class App extends Application {
    private static App ctx;

    @Override
    public void onCreate() {
        App.ctx = this;
        super.onCreate();
    }

    public static App ctx() {
        return ctx;
    }
}
