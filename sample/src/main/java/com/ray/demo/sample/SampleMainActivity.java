package com.ray.demo.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 *
 * Created by Ray on 16/2/17.
 */
public class SampleMainActivity extends AppCompatActivity {

//    static {
//        System.loadLibrary("hell");
//    }

    TextView consoleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_main);
        consoleTv = (TextView) findViewById(R.id.console_tv);
    }

    public void click_Jni(View view) {
//        consoleTv.append(new HelloJni().stringFromJNI());
        Solution.singleNumber(new int[]{0,0,1,2});
    }
}
