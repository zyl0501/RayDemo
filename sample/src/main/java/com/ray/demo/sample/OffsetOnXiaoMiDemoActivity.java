package com.ray.demo.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zyl on 2016/4/5.
 */
public class OffsetOnXiaoMiDemoActivity extends AppCompatActivity{
    Button offsetBtn;
    View offsetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_mi_offset);

        offsetBtn = (Button) findViewById(android.R.id.button1);
        offsetView = findViewById(R.id.offset_view);

        offsetBtn.setOnClickListener(new View.OnClickListener() {
            int offset = 0;

            @Override
            public void onClick(View v) {
                offset = (offset + 200 ) % 900;
                offsetView.offsetLeftAndRight(offset);
            }
        });
    }
}
