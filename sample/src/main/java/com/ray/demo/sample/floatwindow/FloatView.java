package com.ray.demo.sample.floatwindow;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ray.demo.common.Log;

public class FloatView extends ImageView {
    private final static String TAG = "FloatView";  
    private float mTouchX;  
    private float mTouchY;  
    private float x;  
    private float y;  
    private float mStartX;  
    private float mStartY;  
    private OnClickListener mClickListener;  
    private WindowManager windowManager = (WindowManager) getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
    // this windowManagerParams is system variable, to save window params.  
    private WindowManager.LayoutParams windowManagerParams = new WindowManager.LayoutParams();

    public FloatView(Context context) {  
        super(context);  
    }  
  
    @Override  
    public boolean onTouchEvent(MotionEvent event) {
        // Get the status bar height.  
        Rect frame = new Rect();
        getWindowVisibleDisplayFrame(frame);  
        int statusBarHeight = frame.top;  
        Log.e(TAG,"statusBarHeight:" + statusBarHeight);
        // get the x and y, base on left-top point.  
        x = event.getRawX();  
        y = event.getRawY() - statusBarHeight; // statusBarHeight is the height of system status bar.  
        Log.e(TAG, "currX" + x + "====currY" + y);  
        switch (event.getAction()) {  
        case MotionEvent.ACTION_DOWN: // get the motion of finger  
            // get the view x&y, base on left-top point  
            mTouchX = event.getX();  
            mTouchY = event.getY();  
            mStartX = x;  
            mStartY = y;  
            Log.e(TAG, "startX" + mTouchX + "====startY" + mTouchY);  
            break;  
        case MotionEvent.ACTION_MOVE: // get the motion of finger.  
            updateViewPosition();  
            break;  
        case MotionEvent.ACTION_UP: // get the motion of finger leave.  
            updateViewPosition();  
            mTouchX = mTouchY = 0;  
            if ((x - mStartX) < 5 && (y - mStartY) < 5) {  
                if (mClickListener != null) {  
                    mClickListener.onClick(this);  
                }  
            }  
            break;  
        }  
        return true;  
    }  
  
    @Override  
    public void setOnClickListener(OnClickListener l) {  
        this.mClickListener = l;  
    }  
  
    private void updateViewPosition() {  
        // update the window position  
        windowManagerParams.x = (int) (x - mTouchX);  
        windowManagerParams.y = (int) (y - mTouchY);  
        windowManager.updateViewLayout(this, windowManagerParams); // refresh to show.  
    }

    public void setWindowLayoutParam(WindowManager.LayoutParams windowLayoutParam) {
        this.windowManagerParams = windowLayoutParam;
    }
}