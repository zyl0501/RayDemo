package com.ray.demo.dagger2.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ray.demo.dagger2.R;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zyl on 2016/6/23.
 */
public class SubCompActivity extends AppCompatActivity {
    @Named("sub2")
    @Inject
    String parentStr;

//    @Inject
//    String parentStr3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);

//        DaggerParentComponent.builder()
//                .build()
//                .plus(new ChildModule())
//                .inject(this);

        Log.d("raytest", "parentStr->" + parentStr);
    }
}
