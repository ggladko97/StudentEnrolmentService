package com.wsiiz.studentservice.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.wsiiz.studentservice.R;

/**
 * Created by hladlyev on 19.12.2017.
 */

public class CardViewAnimator extends CardView {

    private FrameLayout flContent, flExpanded;
    private ImageButton ibExpand;
    private boolean isExpanded = false;

    public CardViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CardViewAnimator(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
        ibExpand.setOnClickListener((v) -> {
            if (isExpanded) {
                isExpanded = false;
                Log.i("Closed", "expanded layout closed");
                collapse(0);
            } else {
                isExpanded = true;
                expand();
            }
        });
    }

    private void init() {
        flContent = findViewById(R.id.flUniverTitle);
        flExpanded = findViewById(R.id.flUniverExpanded);
        ibExpand = findViewById(R.id.ibExpand);
    }

    public void attachTitleContent(int layId) {
        inflate(getContext(), layId, flContent);
    }

    public void attachExpandedContent(int layId) {
        inflate(getContext(), layId, flExpanded);
    }

    public void expand() {
        int initialHeight = flExpanded.getHeight();


        flExpanded.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int targetHeight = flExpanded.getMeasuredHeight();

        int distanceToExpand = targetHeight - initialHeight;
        flExpanded.setVisibility(VISIBLE);

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1){
                    Toast.makeText(getContext(), "Expanded", Toast.LENGTH_LONG).show();
                }

                flExpanded.getLayoutParams().height = (int) (initialHeight + (distanceToExpand * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToExpand);
        flExpanded.startAnimation(a);
    }

    public void collapse(int collapsedHeight) {
        int initialHeight = flExpanded.getMeasuredHeight();

        int distanceToCollapse = (int) (initialHeight - collapsedHeight);
        flExpanded.setVisibility(GONE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1){
                    Toast.makeText(getContext(), "Collapsed", Toast.LENGTH_LONG).show();
                }
                Log.i("ANIMATOR", "Collapse | InterpolatedTime = " + interpolatedTime);

                flExpanded.getLayoutParams().height = (int) (initialHeight - (distanceToCollapse * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToCollapse);
        flExpanded.startAnimation(a);
    }

    public boolean isExpanded() {
        return isExpanded;
    }
}
