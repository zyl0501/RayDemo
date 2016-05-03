package com.ray.demo.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by qq448 on 2016/5/3.
 */
public class ViewWrapTestActivity extends AppCompatActivity {
    TextView textView;
    TextLayoutView textLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_test);

        textView = (TextView) findViewById(R.id.raw_text);
        textLayoutView = (TextLayoutView) findViewById(R.id.text_layout_view);

        textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                textView.getViewTreeObserver().removeOnPreDrawListener(this);
                textLayoutView.setLayout(textView.getLayout());
                return false;
            }
        });
    }
}
