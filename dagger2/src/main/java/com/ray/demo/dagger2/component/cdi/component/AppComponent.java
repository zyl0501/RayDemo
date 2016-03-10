package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.component.cdi.PerApp;
import com.ray.demo.dagger2.component.cdi.module.AppModule;
import com.ray.demo.dagger2.component.cdi.module.SplashModule;
import com.ray.demo.dagger2.component.cdi.module.UserModule;

import dagger.Component;

/**
 * Created by Ray on 16/3/8.
 */
@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {
    SplashComponent plus(SplashModule module);

    UserComponent plus(UserModule module);
}
