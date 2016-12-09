package com.ray.demo.dagger2.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ray.demo.dagger2.R;
import com.ray.demo.dagger2.app.model.UserManager;
import com.ray.demo.dagger2.component.cdi.CDI;

import javax.inject.Inject;

/**
 * 创建时间：2016/10/11
 *
 * @author zyl
 */
public class UserSubActivity extends AppCompatActivity {
  @Inject
  UserManager userManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_sub);
    CDI.getUserComponent()
        .inject(this);

    Log.e("a","");
    Log.e("raytest", "UserSubActivity userManager: " + userManager);
  }
}
