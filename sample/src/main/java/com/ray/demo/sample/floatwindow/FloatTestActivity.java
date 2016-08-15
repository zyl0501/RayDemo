package com.ray.demo.sample.floatwindow;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

import com.ray.demo.sample.R;

/**
 * Created by zyl on 2016/6/30.
 */
public class FloatTestActivity extends AppCompatActivity implements View.OnClickListener{
    private WindowManager windowManager = null;
    private LayoutParams windowManagerParams = null;
    private FloatView floatView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);


        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createView();
            }
        });
    }

    private void createView() {
        floatView = new FloatView(getApplicationContext());
        floatView.setOnClickListener(this);
        floatView.setImageResource(R.drawable.ic_assistant_photo_white_36dp); // use default icon.
        //get WindowManager
        windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        // set LayoutParams(global) params
        windowManagerParams = new WindowManager.LayoutParams();
        windowManagerParams.type = LayoutParams.TYPE_PHONE; // set window type
        windowManagerParams.format = PixelFormat.RGBA_8888; // set pic format, background transparent
        // set Window flag
        windowManagerParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL| LayoutParams.FLAG_NOT_FOCUSABLE;
        /*
         * PS: flag value should be： LayoutParams.FLAG_NOT_TOUCH_MODAL not effect event
         * LayoutParams.FLAG_NOT_FOCUSABLE unable focus. LayoutParams.FLAG_NOT_TOUCHABLE
         * unable touch focus.
         */
        // adjust the window to left-top
        windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
        // set x.y base on left-top
        windowManagerParams.x = 0;
        windowManagerParams.y = 0;
        // set float window height, weight.
        windowManagerParams.width = LayoutParams.WRAP_CONTENT;
        windowManagerParams.height = LayoutParams.WRAP_CONTENT;

        floatView.setWindowLayoutParam(windowManagerParams);
        // show my float view.
        windowManager.addView(floatView, windowManagerParams);
    }

    public void onClick(View v) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
