package com.ray.demo.dagger2.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ray.demo.dagger2.R;
import com.ray.demo.dagger2.app.model.User;
import com.ray.demo.dagger2.component.cdi.CDI;

public class DaggerLoginActivity extends AppCompatActivity {

  Button loginBtn;
  EditText usernameEdt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dagger_main);
    loginBtn = (Button) findViewById(R.id.login);
    usernameEdt = (EditText) findViewById(R.id.username);

    loginBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(!TextUtils.isEmpty(usernameEdt.getText())){
          User user = new User();
          user.setName(usernameEdt.getText().toString());
          CDI.createUserComponent(user);

          startActivity(new Intent(DaggerLoginActivity.this, UserActivity.class));
        }
      }
    });
  }
}
