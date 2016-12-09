package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.app.HttpClient;
import com.ray.demo.dagger2.component.cdi.AppScope;
import com.ray.demo.dagger2.component.cdi.module.AppModule;

import dagger.Component;

/**
 * Created by Ray on 16/3/8.
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    HttpClient httpClient();
}
