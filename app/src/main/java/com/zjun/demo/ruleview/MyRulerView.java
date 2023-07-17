package com.zjun.demo.ruleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zjun.widget.RuleView;
import com.zjun.widget.TimeRuleView;

public class MyRulerView extends FrameLayout {
    private float indicatorHeight = 100;//260;
    private float indicatorWidth = 4;
    private int indicatorColor = Color.GREEN;

    public MyRulerView(@NonNull Context context) {
        super(context);
        setUpView(context, null);
    }

    public MyRulerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpView(context,attrs);
    }

    public MyRulerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpView(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private static final String TAG_LEFT_THUMBNAIL = "tag_left_thumbnail";
    private static final String TAG_LEFT_TEXTVIEW = "tag_left_text_view";
    private void setUpView(Context context, AttributeSet attrs) {


        TimeRuleView rulerScroller = new TimeRuleView(context, attrs);
        int MiddleLinePosition = rulerScroller.getMiddleLinePosition();
        Log.i("hhb", "middleLinePosition=" + MiddleLinePosition);
        addView(rulerScroller);

        View indicator = new View(context);
        LayoutParams params = new LayoutParams((int)indicatorWidth, (int)indicatorHeight);
//        params.gravity = Gravity.CENTER;
        indicator.setLayoutParams(params);
//        indicator.setX(MiddleLinePosition);
        indicator.setBackgroundColor(indicatorColor);
        addView(indicator);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutParams p = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        View leftView = layoutInflater.inflate(R.layout.view_ruler_choose_time, (ViewGroup) getRootView(), false);
        leftView.setTag(TAG_LEFT_THUMBNAIL);
        leftView.setLayoutParams(p);
        TextView leftTimeView = (TextView) leftView.findViewById(R.id.tv_time);
        leftTimeView.setTag(TAG_LEFT_TEXTVIEW);

        addView(leftView);

        rulerScroller.setOnTimeChangedListener(new TimeRuleView.OnTimeChangedListener() {
            @Override
            public void onPrepared(float timeline) {
                int position = rulerScroller.getMiddleLinePosition();
                Log.w("hhb", "position=" + position + ", getWidth=" + leftView.getWidth() + ", h="+leftView.getMeasuredWidth());
                indicator.setX(position);
                leftView.setX(position - (leftView.getMeasuredWidth()/2));

            }

            @Override
            public void onTimeChanged(int newTimeValue) {
                leftTimeView.setText(TimeRuleView.formatTimeHHmmss(newTimeValue));
            }
        });
    }



}
