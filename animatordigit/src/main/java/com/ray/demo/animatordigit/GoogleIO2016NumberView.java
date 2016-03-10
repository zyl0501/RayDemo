/*
 * Copyright 2016 eneim@Eneim Labs, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ray.demo.animatordigit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.InflateException;

import com.ray.demo.animatordigit.util.AnimationUtil;
import com.ray.demo.animatordigit.util.NumberDrawer;
import com.ray.demo.animatordigit.util.PathParser;
import com.ray.demo.animatordigit.util.Number;

/**
 * Created by eneim on 3/4/16.
 */
public class GoogleIO2016NumberView extends AppCompatImageButton {

  private static final int NO_VALUE = -1;

  private int mValue;

  private Number mNumber;

  private PathParser.PathDataNode[] mNodes;

  private NumberDrawer.NumberDrawable mDrawable;

  private int mSize;

  public GoogleIO2016NumberView(Context context) {
    this(context, null);
  }

  public GoogleIO2016NumberView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public GoogleIO2016NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GoogleIO2016NumberView);
    mValue = a.getInt(R.styleable.GoogleIO2016NumberView_value, -1);

    TypedValue typedValue = new TypedValue();
    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
    mSize = context.getResources().getDimensionPixelSize(typedValue.resourceId);

    if (a.hasValue(R.styleable.GoogleIO2016NumberView_size)) {
      mSize = a.getDimensionPixelSize(R.styleable.GoogleIO2016NumberView_size, mSize);
    }
    a.recycle();

    if (mValue == NO_VALUE) {
      throw new IllegalArgumentException("Value must be set");
    }

    mNumber = Number.VALUES[mValue];
    mNodes = Number.getNodes(mNumber);
    mDrawable = (NumberDrawer.NumberDrawable) NumberDrawer.getDrawable(mNumber, mSize);
    // setImageDrawable(mDrawable);
  }

  private PathParser.PathDataNode[] nodesFrom;
  private PathParser.PathDataNode[] nodesTo;
  private TypeEvaluator evaluator;
  private ValueAnimator animator;

  public void animateTo(final Number number) {
    if (number == mNumber) {
      return;
    }

    Pair<String, String> pathValues = Number.alignNumbers(new Pair<>(mNumber, number));
    nodesFrom = PathParser.createNodesFromPathData(pathValues.first);
    nodesTo = PathParser.createNodesFromPathData(pathValues.second);

    PropertyValuesHolder valuesHolder;
    evaluator = new AnimationUtil.PathDataEvaluator(PathParser.deepCopyNodes(nodesFrom));
    if (!PathParser.canMorph(nodesFrom, nodesTo)) {
      throw new InflateException(" Can't morph from " + pathValues.first + " to " +
          pathValues.second);
    }

    valuesHolder = PropertyValuesHolder.ofObject("pathData", evaluator, nodesFrom, nodesTo);
    animator = ValueAnimator.ofPropertyValuesHolder(valuesHolder);
    if (animator != null) {
      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          mNodes = (PathParser.PathDataNode[]) animation.getAnimatedValue();
          invalidate();
        }
      });
      animator.addListener(new AnimatorListenerAdapter() {
        @Override public void onAnimationEnd(Animator animation) {
          mNumber = number;
          reset();
        }
      });
      animator.start();
    }
  }

  private static final String TAG = "GoogleIo2016NumberView";

  public void reset() {
    mNodes = Number.getNodes(mNumber);
    mDrawable = (NumberDrawer.NumberDrawable) NumberDrawer.getDrawable(mNumber, mSize);
    invalidate();
  }

  public void setNumber(Number number) {
    if (this.mNumber != number) {
      mNumber = number;
      reset();
    }
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int width = getWidth() - getPaddingLeft() - getPaddingRight();
    int height = getHeight() - getPaddingTop() - getPaddingBottom();
    if (width < 0) {
      width = mSize;
    }

    if (height < 0) {
      height = mSize;
    }

    NumberDrawer.draw(canvas, width, height, getPaddingLeft(), getPaddingTop(), mNodes);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    setMeasuredDimension(mSize + getPaddingLeft() + getPaddingRight(),
        mSize + getPaddingTop() + getPaddingBottom());
  }
}
