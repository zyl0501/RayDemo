package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.app.view.SplashActivity;
import com.ray.demo.dagger2.component.cdi.PerApp;
import com.ray.demo.dagger2.component.cdi.module.SplashModule;

import dagger.Subcomponent;

/**
 * Created by Ray on 16/3/8.
 */
@PerApp
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}
