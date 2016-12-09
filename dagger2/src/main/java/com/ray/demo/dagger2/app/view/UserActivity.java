package com.ray.demo.dagger2.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ray.demo.dagger2.R;
import com.ray.demo.dagger2.app.HttpClient;
import com.ray.demo.dagger2.app.model.UserManager;
import com.ray.demo.dagger2.component.cdi.CDI;

import javax.inject.Inject;

/**
 * 创建时间：2016/10/11
 *
 * @author zyl
 */
public class UserActivity extends AppCompatActivity {

  @Inject
  UserManager userManager;
  @Inject
  HttpClient httpClient;

  TextView usernameTv;
  Button logoutBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user);
    CDI.getUserComponent()
        .inject(this);

    usernameTv = (TextView) findViewById(R.id.username);
    logoutBtn = (Button) findViewById(R.id.logout);

    usernameTv.setText(userManager.getLoginUser().getName());
    logoutBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    findViewById(R.id.next)
        .setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(UserActivity.this, UserSubActivity.class));
          }
        });

    Log.e("raytest", "UserActivity userManager: " +userManager);
  }

  @Override
  protected void onDestroy() {
    CDI.releaseUserComponent();
    super.onDestroy();
  }
}
