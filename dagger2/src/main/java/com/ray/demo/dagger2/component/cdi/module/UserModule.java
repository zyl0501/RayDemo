package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.model.User;
import com.ray.demo.dagger2.app.model.UserManager;
import com.ray.demo.dagger2.component.cdi.UserScope;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

  User user;

  public UserModule(User user) {
    this.user = user;
  }

  @UserScope
  @Provides
  UserManager providesUser() {
    return new UserManager(user);
  }
}
