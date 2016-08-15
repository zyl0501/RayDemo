package com.ray.demo.dagger2.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ray.demo.dagger2.R;
import com.ray.demo.dagger2.app.present.SplashPresent;

import javax.inject.Inject;

/**
 * Created by Ray on 16/3/8.
 */
public class SplashActivity extends AppCompatActivity {

    @Inject
    SplashPresent splashPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_splash);

        ((TextView) findViewById(R.id.splash_count)).append(splashPresent.getSplashImgCount() + "");
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, UserDetailActivity.class));
            }
        });
    }
}
