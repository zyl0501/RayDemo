package com.ray.test;

/**
 * 创建时间：2016/12/23
 *
 * @author zyl
 */
public class AccountManager {
  private AccountSource accountSource;

  public AccountManager(AccountSource accountSource) {
    this.accountSource = accountSource;
  }

  public void login(String username, String password){
    accountSource.login(username, password);
  }
}
