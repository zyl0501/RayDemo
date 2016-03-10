package com.ray.demo.dagger2.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ray.demo.dagger2.R;

/**
 * Created by Ray on 16/3/8.
 */
public class UserDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_user_detail);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.user_info_container, new UserInfoFragment())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.news_container, new HotNewsFragment())
                .commit();
    }
}
