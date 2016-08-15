package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.component.cdi.module.ChildModule;
import com.ray.demo.dagger2.component.cdi.module.ParentModule;
import com.ray.demo.dagger2.component.cdi.module.SplashModule;

import dagger.Component;

@Component(modules = {ParentModule.class})
public interface ParentComponent {
    SplashComponent plus(SplashModule module);

    ChildComponent plus(ChildModule module);
}
