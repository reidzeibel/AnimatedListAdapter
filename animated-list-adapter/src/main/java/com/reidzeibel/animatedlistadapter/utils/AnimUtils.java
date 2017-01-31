package com.reidzeibel.animatedlistadapter.utils;

import android.content.Context;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by RidwanAditama on 16/01/2017.
 */

public class AnimUtils {

    private AnimUtils() { }

    private static Interpolator fastOutSlowIn;
    private static Interpolator fastOutLinearIn;
    private static Interpolator linearOutSlowIn;
    private static Interpolator linear;

    public static Interpolator getFastOutSlowInInterpolator(Context context) {
        if (fastOutSlowIn == null) {
            fastOutSlowIn = new FastOutSlowInInterpolator();
        }
        return fastOutSlowIn;
    }

    public static Interpolator getFastOutLinearInInterpolator(Context context) {
        if (fastOutLinearIn == null) {
            fastOutLinearIn = new FastOutLinearInInterpolator();
        }
        return fastOutLinearIn;
    }

    public static Interpolator getLinearOutSlowInInterpolator(Context context) {
        if (linearOutSlowIn == null) {
            linearOutSlowIn = new LinearOutSlowInInterpolator();
        }
        return linearOutSlowIn;
    }

    public static Interpolator getLinearInterpolator() {
        if (linear == null) {
            linear = new LinearInterpolator();
        }
        return linear;
    }
}
