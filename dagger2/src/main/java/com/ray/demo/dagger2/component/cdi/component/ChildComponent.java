package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.app.view.SubCompActivity;
import com.ray.demo.dagger2.component.cdi.PerUser;
import com.ray.demo.dagger2.component.cdi.module.ChildModule;

import dagger.Subcomponent;

/**
 * Created by Ray on 16/3/8.
 */
@PerUser
@Subcomponent(modules = ChildModule.class)
public interface ChildComponent {

    void inject(SubCompActivity subCompActivity);
}
