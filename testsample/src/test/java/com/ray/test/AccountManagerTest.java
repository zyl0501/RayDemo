package com.ray.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by zyl on 2016/12/23.
 */
public class AccountManagerTest {

  @Mock
  AccountSource accountSource;
  @Mock
  AccountManager accountManager;

  @Before
  public void setup() {
    //初始化@Mock注解的对象 (进行注入)
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void login() throws Exception {
    AccountManager accountManager = new AccountManager(accountSource);
    accountManager.login("a", "1");

    Mockito.verify(accountSource).login("a", "1");
  }

}