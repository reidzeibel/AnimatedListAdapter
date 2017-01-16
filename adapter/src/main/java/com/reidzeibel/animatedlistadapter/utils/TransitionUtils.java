package com.reidzeibel.animatedlistadapter.utils;

import android.transition.Transition;

/**
 * Created by RidwanAditama on 16/01/2017.
 */

public class TransitionUtils {

    public static class TransitionListenerAdapter implements Transition.TransitionListener {

        @Override public void onTransitionStart(Transition transition) { }

        @Override public void onTransitionEnd(Transition transition) { }

        @Override public void onTransitionCancel(Transition transition) { }

        @Override public void onTransitionPause(Transition transition) { }

        @Override public void onTransitionResume(Transition transition) { }
    }
}
