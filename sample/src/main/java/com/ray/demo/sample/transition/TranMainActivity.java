package com.ray.demo.sample.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ray.demo.sample.R;

/**
 * Created by zyl on 2016/4/29.
 */
public class TranMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_main);
    }

    public void click(View view){
        ActivityCompat.startActivity(this, new Intent(this, TranSubActivity.class),
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,view,"a").toBundle());
    }
}
