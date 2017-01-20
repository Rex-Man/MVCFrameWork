package com.oocl.mob.opencvproject;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.oocl.mob.opencvproject.common.GreenDAOUtils;
import com.oocl.mob.opencvproject.config.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by manre on 1/11/17.
 */

public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mContext=getApplicationContext();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
        GreenDAOUtils.getmInstance(mContext);
    }
    public static Context getContext()
    {
        return mContext;
    }
}
