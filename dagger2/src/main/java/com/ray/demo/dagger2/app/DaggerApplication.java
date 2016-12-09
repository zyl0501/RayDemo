package com.ray.demo.dagger2.app;

import android.app.Application;

import com.ray.demo.dagger2.app.model.User;
import com.ray.demo.dagger2.component.cdi.component.AppComponent;
import com.ray.demo.dagger2.component.cdi.component.UserComponent;

/**
 * 创建时间：2016/10/11
 *
 * @author zyl
 */
public class DaggerApplication extends Application {
  static DaggerApplication mInstance;

  AppComponent appComponent;
  UserComponent userComponent;

  public static DaggerApplication ctx(){
    return mInstance;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
  }

  public UserComponent createUserComponent(User user) {
    return userComponent;
  }

  public UserComponent getUserComponent(){
    return userComponent;
  }

  public void releaseUserComponent(){
    userComponent = null;
  }
}
