package com.ray.demo.sample.badge;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zyl on 2016/8/11.
 */
public class BadgeNumber {
    private int badgeId;//badge number真正的类型
    private int count;//badge number的count
    private @BadgeMode int displayMode;//当前badge number在父节点上的显示方式

    public BadgeNumber() {
    }

    public BadgeNumber(int badgeId) {
        this.badgeId = badgeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public @BadgeMode int getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(int displayMode) {
        this.displayMode = displayMode;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    @IntDef({
            BadgeMode.NUMBER,
            BadgeMode.DOT,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeMode {
        /**
         * 数字
         */
        short NUMBER =1;

        /**
         * 红点
         */
        short DOT =2;

    }
}
