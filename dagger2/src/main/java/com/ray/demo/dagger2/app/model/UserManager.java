package com.ray.demo.dagger2.app.model;

import com.ray.demo.dagger2.component.cdi.UserScope;

import javax.inject.Inject;

/**
 * 创建时间：2016/10/11
 *
 * @author zyl
 */
@UserScope
public class UserManager {
  User loginUser;

  @Inject
  public UserManager(User user) {
    this.loginUser = user;
  }

  public User getLoginUser() {
    return loginUser;
  }
}
