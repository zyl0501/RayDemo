package com.ray.demo.dagger2.component.cdi.component;

import android.app.Activity;

import com.ray.demo.dagger2.component.cdi.PerActivity;
import com.ray.demo.dagger2.component.cdi.module.ActivityModule;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}