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

package com.ray.demo.animatordigit.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * Created by eneim on 3/4/16.
 */
public final class NumberDrawer {

  private static final Paint p = new Paint();
  private static final Paint ps = new Paint();
  private static final Path t = new Path();
  private static final Matrix m = new Matrix();
  private static float od;
  protected static ColorFilter cf = null;

  private static @ColorInt int strokeColor = Color.parseColor("#78909C");

  /**
   * IMPORTANT: Due to the static usage of this class this
   * method sets the tint color statically. So it is highly
   * recommended to call the clearColorTint method when you
   * have finished drawing.
   * <p/>
   * Sets the color to use when drawing the SVG. This replaces
   * all parts of the drawable which are not completely
   * transparent with this color.
   */
  public static void setColorTint(int color) {
    cf = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
  }

  public static void clearColorTint(int color) {
    cf = null;
  }

  public static void draw(Canvas c, int w, int h, int dx, int dy, PathParser.PathDataNode[] nodes) {
    float ow = 132f;
    float oh = 132f;

    od = (w / ow < h / oh) ? w / ow : h / oh;

    r();
    c.save();
    c.translate((w - od * ow) / 2f + dx, (h - od * oh) / 2f + dy);

    m.reset();
    m.setScale(od, od);

    c.save();
    ps.setColor(Color.argb(0, 0, 0, 0));
    ps.setStrokeCap(Paint.Cap.BUTT);
    ps.setStrokeJoin(Paint.Join.MITER);
    ps.setStrokeMiter(4.0f * od);
    c.scale(1.0f, 1.0f);
    c.save();
    p.setColor(Color.argb(0, 0, 0, 0));
    ps.setColor(strokeColor);
    ps.setStrokeWidth(4.0f * od);
    ps.setStrokeJoin(Paint.Join.ROUND);
    t.reset();

    for (PathParser.PathDataNode node : nodes) {
      if (node.type == 'M') {
        t.moveTo(node.params[0], node.params[1]);
      } else if (node.type == 'L') {
        t.lineTo(node.params[0], node.params[1]);
      } else if (node.type == 'C') {
        t.cubicTo(node.params[0], node.params[1], node.params[2], node.params[3], node.params[4],
            node.params[5]);
      }
    }

    t.transform(m);
    c.drawPath(t, p);
    c.drawPath(t, ps);
    c.restore();
    r(3, 2, 0, 1);
    p.setColor(Color.argb(0, 0, 0, 0));
    ps.setColor(Color.parseColor("#e35444"));
    ps.setStrokeWidth(4.0f * od);
    ps.setStrokeJoin(Paint.Join.ROUND);
    c.restore();
    r();

    c.restore();
  }

  public static Drawable getDrawable(Number number, int size) {
    return new NumberDrawable(number, size);
  }

  public static Drawable getTintedDrawable(Number number, int size, int color) {
    return new NumberDrawable(number, size, color);
  }

  public static class NumberDrawable extends Drawable {
    private int size = 0;
    private ColorFilter colorFilter = null;

    private Number number;

    public NumberDrawable(Number number, int size) {
      this.number = number;
      this.size = size;
      setBounds(0, 0, size, size);
      invalidateSelf();
    }

    public NumberDrawable(Number number, int size, int color) {
      this(number, size);
      colorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    @Override public int getIntrinsicHeight() {
      return size;
    }

    @Override public int getIntrinsicWidth() {
      return size;
    }

    @Override public void draw(Canvas c) {
      Rect b = getBounds();
      NumberDrawer.cf = colorFilter;
      NumberDrawer.draw(c, b.width(), b.height(), b.left, b.top, Number.getNodes(number));
      NumberDrawer.cf = null;
    }

    @Override public void setAlpha(int i) {
    }

    @Override public void setColorFilter(ColorFilter c) {
      colorFilter = c;
      invalidateSelf();
    }

    @Override public int getOpacity() {
      return 0;
    }
  }

  private static void r(Integer... o) {
    p.reset();
    ps.reset();
    if (cf != null) {
      p.setColorFilter(cf);
      ps.setColorFilter(cf);
    }
    p.setAntiAlias(true);
    ps.setAntiAlias(true);
    p.setStyle(Paint.Style.FILL);
    ps.setStyle(Paint.Style.STROKE);
    for (Integer i : o) {
      switch (i) {
        case 0:
          ps.setStrokeJoin(Paint.Join.MITER);
          break;
        case 1:
          ps.setStrokeMiter(4.0f * od);
          break;
        case 2:
          ps.setStrokeCap(Paint.Cap.BUTT);
          break;
        case 3:
          ps.setColor(Color.argb(0, 0, 0, 0));
          break;
      }
    }
  }
}
