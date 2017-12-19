package com.wsiiz.studentservice.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

/**
 * Created by hladlyev on 19.12.2017.
 */

public class CardViewAnimator extends CardView {


    public CardViewAnimator(Context context) {
        super(context);
    }

    public void expand() {
        int initialHeight = getHeight();

        measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int targetHeight = getMeasuredHeight();

        int distanceToExpand = targetHeight - initialHeight;

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1){
                    Toast.makeText(getContext(), "Expanded", Toast.LENGTH_LONG).show();
                }

                getLayoutParams().height = (int) (initialHeight + (distanceToExpand * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToExpand);
        startAnimation(a);
    }

    public void collapse(int collapsedHeight) {
        int initialHeight = getMeasuredHeight();

        int distanceToCollapse = (int) (initialHeight - collapsedHeight);

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1){
                    Toast.makeText(getContext(), "Collapsed", Toast.LENGTH_LONG).show();
                }
                Log.i("ANIMATOR", "Collapse | InterpolatedTime = " + interpolatedTime);

                getLayoutParams().height = (int) (initialHeight - (distanceToCollapse * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToCollapse);
        startAnimation(a);
    }
}
