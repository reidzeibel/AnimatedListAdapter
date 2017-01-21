package com.reidzeibel.animatedlistadapter;

import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;

import com.reidzeibel.animatedlistadapter.animator.SlideInItemAnimator;
import com.reidzeibel.animatedlistadapter.utils.TransitionUtils;

import static com.reidzeibel.animatedlistadapter.utils.AnimUtils.getFastOutSlowInInterpolator;

/**
 * Created by RidwanAditama on 16/01/2017.
 */

public abstract class BaseAnimatedListAdapter <T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private static final int EXPAND = 0x1;
    private static final int COLLAPSE = 0x2;

    private RecyclerView mRecyclerView;
    public int mExpandedPosition = -1;
    private ItemAnimator itemAnimator;

    private Transition expandCollapse;

    private View.OnTouchListener touchEater = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void initAnimatedListAdapter() {
        itemAnimator = new ItemAnimator();
        mRecyclerView.setItemAnimator(itemAnimator);

        expandCollapse = new AutoTransition();
        expandCollapse.setDuration(120);
        expandCollapse.setInterpolator(getFastOutSlowInInterpolator(mRecyclerView.getContext()));
        expandCollapse.addListener(new TransitionUtils.TransitionListenerAdapter() {
            @Override
            public void onTransitionStart(Transition transition) {
                mRecyclerView.setOnTouchListener(touchEater);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                itemAnimator.setAnimateMoves(true);
                mRecyclerView.setOnTouchListener(null);
                if (mExpandedPosition != -1) mRecyclerView.smoothScrollToPosition(mExpandedPosition);
            }
        });
    }

    public void setClickListener(final T holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int position = holder.getAdapterPosition();
                if (position == RecyclerView.NO_POSITION) return;

                TransitionManager.beginDelayedTransition(mRecyclerView, expandCollapse);
                itemAnimator.setAnimateMoves(false);

                if (RecyclerView.NO_POSITION != mExpandedPosition) {
                    notifyItemChanged(mExpandedPosition, COLLAPSE);
                }

                if (mExpandedPosition != position) {
                    mExpandedPosition = position;
                    notifyItemChanged(position, EXPAND);
                    holder.itemView.requestFocus();
                } else {
                    mExpandedPosition = RecyclerView.NO_POSITION;
                }

            }
        });
    }

    /**
     * A {@link RecyclerView.ItemAnimator} which allows disabling move animations. RecyclerView
     * does not like animating item height changes. {@link android.transition.ChangeBounds} allows
     * this but in order to simultaneously collapse one item and expand another, we need to run the
     * Transition on the entire RecyclerView. As such it attempts to move views around. This
     * custom item animator allows us to stop RecyclerView from trying to handle this for us while
     * the transition is running.
     */
    static class ItemAnimator extends SlideInItemAnimator {

        private boolean animateMoves = false;

        ItemAnimator() {
            super();
        }

        void setAnimateMoves(boolean animateMoves) {
            this.animateMoves = animateMoves;
        }

        @Override
        public boolean animateMove(
                RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            if (!animateMoves) {
                dispatchMoveFinished(holder);
                return false;
            }
            return super.animateMove(holder, fromX, fromY, toX, toY);
        }
    }
}