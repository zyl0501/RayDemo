package com.ray.demo.dagger2.app.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ray.demo.dagger2.R;
import com.ray.demo.dagger2.app.model.User;
import com.ray.demo.dagger2.app.present.UserPresent;
import com.ray.demo.dagger2.component.cdi.component.ActivityComponent;
import com.ray.demo.dagger2.component.cdi.component.DaggerActivityComponent;
import com.ray.demo.dagger2.component.cdi.component.DaggerUserComponent;
import com.ray.demo.dagger2.component.cdi.module.ActivityModule;
import com.ray.demo.dagger2.component.cdi.module.UserModule;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;

/**
 * Created by Ray on 16/3/7.
 */
public class DraggerActivity extends AppCompatActivity {

    @Named("no arg")
    @Inject
    UserPresent userPresent1;
    @Named("no arg")
    @Inject
    Lazy<UserPresent> userPresentLazy;
    @Named("no arg")
    @Inject
    Provider<UserPresent> userPresentProvider;
    @Named("no arg")
    @Inject
    int integer;

    @Named("1 arg")
    @Inject
    UserPresent userPresent2;

    @Inject
    Activity activity;

    @Inject
    int d;

//    @Named("sub")
//    @Inject
//    String s;
//
//    @Inject
//    long l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        DaggerUserComponent.builder()
                .userModule(new UserModule())
                .activityComponent(activityComponent)
//                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);


        Log.d("raytest", "this->" + this);
        Log.d("raytest", "activity->" + activity);
        Log.d("raytest", "d->" + d);
//        Log.d("raytest","l->"+l);
//        Log.d("raytest","s->"+s);
        UserPresent userPresent = userPresentLazy.get();

        User user = userPresent.getUser("aaa");
        ((TextView) findViewById(R.id.textView)).setText(user.getName());
        ((TextView) findViewById(R.id.textView)).append("\n");
        ((TextView) findViewById(R.id.textView)).append(userPresent.getInfo());
        ((TextView) findViewById(R.id.textView)).append("\n");
        ((TextView) findViewById(R.id.textView)).append(integer + "");
    }
}
