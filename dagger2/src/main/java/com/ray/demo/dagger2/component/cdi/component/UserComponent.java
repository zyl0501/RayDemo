package com.ray.demo.dagger2.component.cdi.component;

import com.ray.demo.dagger2.app.view.DaggerLoginActivity;
import com.ray.demo.dagger2.app.view.UserActivity;
import com.ray.demo.dagger2.app.view.UserDetailActivity;
import com.ray.demo.dagger2.app.view.UserSubActivity;
import com.ray.demo.dagger2.component.cdi.UserScope;
import com.ray.demo.dagger2.component.cdi.module.UserModule;

import dagger.Component;

@UserScope
@Component(dependencies = {AppComponent.class}, modules = {UserModule.class})
public interface UserComponent {

    void inject(UserDetailActivity activity);

    void inject(DaggerLoginActivity activity);

    void inject(UserActivity userActivity);

    void inject(UserSubActivity userSubActivity);
}
