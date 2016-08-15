package com.ray.demo.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by qq448 on 2016/8/14.
 */
public class BadgeView extends FrameLayout {
    boolean isNumber = true;
    int count = 0;
    boolean isShowBadge = false;

    TextView badgeNumberView;
    View badgeDotView;

    public BadgeView(Context context) {
        super(context);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        badgeNumberView = new TextView(getContext());
        badgeNumberView.setBackgroundResource(R.drawable.red_badge);
        LayoutParams lp = generateDefaultLayoutParams();
        lp.width = 60;
        lp.height = 60;
        lp.gravity = Gravity.TOP | Gravity.RIGHT;
        badgeNumberView.setGravity(Gravity.CENTER);
        addView(badgeNumberView,0, lp);


        badgeDotView = new View(getContext());
        badgeDotView.setBackgroundResource(R.drawable.red_badge);
        LayoutParams lp2 = generateDefaultLayoutParams();
        lp2.width = 30;
        lp2.height = 30;
        lp2.gravity = Gravity.TOP | Gravity.RIGHT;
        addView(badgeDotView,0, lp2);

        updateUI();
    }

    public void setCount(int count) {
        this.count = count;
        badgeNumberView.setText(String.valueOf(count));
        updateUI();
    }

    public void setMode(boolean isNumber) {
        this.isNumber = isNumber;
        updateUI();
    }

    private void updateUI() {
        showBadge(isShowBadge);
    }

    public void showBadge(boolean show) {
        this.isShowBadge = show;
        if (show) {
            if (isNumber) {
                badgeNumberView.setVisibility(View.VISIBLE);
                badgeNumberView.bringToFront();
                badgeDotView.setVisibility(View.GONE);
            } else {
                badgeDotView.setVisibility(View.VISIBLE);
                badgeNumberView.setVisibility(View.GONE);
                badgeDotView.bringToFront();
            }
        } else {
            badgeDotView.setVisibility(View.GONE);
            badgeNumberView.setVisibility(View.GONE);
        }
    }

    public void clearBadge(){
         count = 0;
         isShowBadge = false;
        updateUI();
    }
}
