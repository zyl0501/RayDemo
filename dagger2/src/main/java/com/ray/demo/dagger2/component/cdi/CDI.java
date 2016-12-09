package com.ray.demo.dagger2.component.cdi;

import com.ray.demo.dagger2.app.model.User;
import com.ray.demo.dagger2.component.cdi.component.AppComponent;
import com.ray.demo.dagger2.component.cdi.component.DaggerAppComponent;
import com.ray.demo.dagger2.component.cdi.component.DaggerUserComponent;
import com.ray.demo.dagger2.component.cdi.component.UserComponent;
import com.ray.demo.dagger2.component.cdi.module.AppModule;
import com.ray.demo.dagger2.component.cdi.module.UserModule;

/**
 * 创建时间：2016/10/11
 *
 * @author zyl
 */
public class CDI {

  static AppComponent appComponent;
  static UserComponent userComponent;

  public static AppComponent injector() {
    if (CDI.appComponent == null) {
      CDI.appComponent = DaggerAppComponent.builder()
          .appModule(new AppModule(null))
          .build();
    }
    return CDI.appComponent;
  }

  public static UserComponent createUserComponent(User user) {
    userComponent = DaggerUserComponent.builder()
        .appComponent(injector())
        .userModule(new UserModule(user))
        .build();
    return userComponent;
  }

  public static UserComponent getUserComponent() {
    return userComponent;
  }

  public static void releaseUserComponent() {
    userComponent = null;
  }
}
