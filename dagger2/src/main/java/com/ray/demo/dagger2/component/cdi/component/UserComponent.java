package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.app.view.DraggerActivity;
import com.ray.demo.dagger2.app.view.UserDetailActivity;
import com.ray.demo.dagger2.component.cdi.PerUser;
import com.ray.demo.dagger2.component.cdi.module.UserModule;

import dagger.Component;

@PerUser
@Component(dependencies = {ActivityComponent.class}, modules = {UserModule.class})
public interface UserComponent {

    void inject(UserDetailActivity activity);

    void inject(DraggerActivity activity);
}
