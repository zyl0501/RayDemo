package com.ray.demo.sample.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ray.demo.sample.R;

/**
 * Created by Ray on 16/2/23.
 */
public class DateBindActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_data_bind);

//        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sample_data_bind);
//        User user = new User("Test", "User");
//        binding.setUser(user);
    }

}
