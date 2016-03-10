package com.ray.demo.dagger2.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ray.demo.dagger2.R;

/**
 * Created by Ray on 16/3/7.
 */
public class DraggerActivity extends AppCompatActivity {

//    @Named("no arg")
//    @Inject
//    UserPresent userPresent1;
//    @Named("no arg")
//    @Inject
//    Lazy<UserPresent> userPresentLazy;
//    @Named("no arg")
//    @Inject
//    Provider<UserPresent> userPresentProvider;
//    @Named("no arg")
//    @Inject
//    int integer;
//
//    @Named("1 arg")
//    @Inject
//    UserPresent userPresent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);

//        DaggerUserComponent.builder()
//                .userModule(new UserModule())
//                .activityModule(new ActivityModule(this))
//                .build()
//                .inject(this);
//        UserPresent userPresent = userPresentLazy.get();
//
//        User user = userPresent.getUser("aaa");
//        ((TextView) findViewById(R.id.textView)).setText(user.getName());
//        ((TextView) findViewById(R.id.textView)).append("\n");
//        ((TextView) findViewById(R.id.textView)).append(userPresent.getInfo());
//        ((TextView) findViewById(R.id.textView)).append("\n");
//        ((TextView) findViewById(R.id.textView)).append(integer + "");
    }
}
