package com.ray.demo.sample.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ray.demo.sample.R;

/**
 * Created by qq448 on 2016/8/15.
 */
public class AnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final View layout = findViewById(R.id.layout);
        final View bottomLayout = findViewById(R.id.bottom_layout);


        layout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ResizeWidthAnimation anim = new ResizeWidthAnimation( layout, 450);
                anim.setDuration(4000);
                layout.startAnimation(anim);
            }
        },4000);

//        Animator anim1 = AnimatorInflater.loadAnimator(this, R.animator.width);
//        anim1.setTarget(layout);
//        anim1.setStartDelay(4000);
//        anim1.start();

        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.translate);
        anim.setTarget(bottomLayout);
        anim.start();
    }
}
