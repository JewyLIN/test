package com.jewy.test;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wonders on 2019/5/17.
 */

public class SPUtil {

    public static final String TAG = "TEST";
    //创建一个写入器
    private static SharedPreferences mSP;
    private static SharedPreferences.Editor mEditor;
    private static SPUtil mSPUtil;

    //构造方法
    public SPUtil(Context context){
        mSP = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        mEditor = mSP.edit();
    }

    //单例
    public static SPUtil getInstance(Context context){
        if (mSPUtil==null){
            mSPUtil = new SPUtil(context);
        }
        return mSPUtil;
    }

    //存入数据
    public void commitData(String key, String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }

    //获取数据
    public String getData(String key){
        return mSP.getString(key,"");
    }

    //清除数据
    public void removeData(String key){
        mEditor.remove(key);
        mEditor.commit();
    }
}
