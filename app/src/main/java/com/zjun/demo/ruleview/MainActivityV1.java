package com.zjun.demo.ruleview;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.zjun.widget.MoneySelectRuleView;
import com.zjun.widget.RuleView;
import com.zjun.widget.TimeRuleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivityV1 extends AppCompatActivity {

    private TimeRuleView trvTime;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v1);

//        tvTime = findViewById(R.id.tv_time);
//        trvTime = findViewById(R.id.trv_time);




//        trvTime.setOnTimeChangedListener(new TimeRuleView.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(int newTimeValue) {
//                tvTime.setText(TimeRuleView.formatTimeHHmmss(newTimeValue));
//            }
//        });
//        // 模拟时间段数据
//        List<TimeRuleView.TimePart> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            TimeRuleView.TimePart part = new TimeRuleView.TimePart();
//            part.startTime = i * 1000;
//            part.endTime = part.startTime + new Random().nextInt(1000);
//            list.add(part);
//        }
//        trvTime.setTimePartList(list);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_rule_indicator:
                toggleSettingsShow(R.id.ll_rule_settings);
                break;

            case R.id.tv_money_indicator:
                toggleSettingsShow(R.id.ll_money_settings);
                break;
             default: break;
        }
    }

    private void toggleSettingsShow(@IdRes int layoutId) {
        LinearLayout llSettings = findViewById(layoutId);
        llSettings.setVisibility(llSettings.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
    }


}
