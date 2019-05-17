package com.jewy.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    private TextView mShowText;
    private Button mClickButton;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        intView();
        setEvent();
    }

    private void intView(){
        mShowText = findViewById(R.id.showText);
        mClickButton = findViewById(R.id.clickButton);
    }

    protected void setEvent(){
        mClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeStr = SPUtil.getInstance(mContext).getData("time");
                Long longTime = TimeUtil.getInstance(mContext).getOsTime();
                String time = TimeUtil.getInstance(mContext).stampToDate(longTime);
                if (("").equals(timeStr)||timeStr==null){
                    mShowText.setText("欢迎初次使用");
                }else{
                    String msg = TimeUtil.getInstance(mContext).timeCompare(timeStr,time);
                    mShowText.setText(msg);
                }
                SPUtil.getInstance(mContext).commitData("time",time);
            }
        });
    }

}
