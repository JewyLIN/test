package com.jewy.test;

import android.content.Context;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wonders on 2019/5/17.
 */

public class TimeUtil {
    public static String TAG= "TimeUtil";
    public static TimeUtil mTimeUtil;
    public Context mContext;
    private SimpleDateFormat format;

    public TimeUtil(Context context){
        this.mContext = context;
    }

    public static TimeUtil getInstance(Context context){
        if (mTimeUtil ==null){
            mTimeUtil = new TimeUtil(context);
        }
        return mTimeUtil;
    }

    //获取系统时间
    public long getOsTime(){
        return System.currentTimeMillis();
    }

    public String timeCompare(String startTime,String endTime){
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = "";
        try {
            Date startDate = format.parse(startTime);//记录的时间
            Date endDate = format.parse(endTime);//当前时间
            long diff = endDate.getTime() - startDate.getTime();//时间差
            long day = diff/(1000*60*60*24);
            //以小时为单位取整
            long hour=(diff/(60*60*1000)-day*24);
            //以分钟为单位取整
            long min=((diff/(60*1000))-day*24*60-hour*60);
            //以秒为单位
            long second=(diff/1000-day*24*60*60-hour*60*60-min*60);
            Log.d(TAG,"day = "+day+"，hour = "+hour+"，min = "+min+"，second = "+second);
            if (day>=0&&day<3){
                msg="欢迎经常使用";
            }else {
                msg="好久不见，欢迎再次使用";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return msg;
    }


    /**
     * 将时间转换为时间戳
     */
    public String dateToStamp(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        return String.valueOf(ts);
    }

    /**
     * 将时间戳转换为时间
     */
    public String stampToDate(long timeMillis){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeMillis);
        return simpleDateFormat.format(date);
    }

}
