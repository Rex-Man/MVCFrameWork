package com.oocl.mob.opencvproject;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.oocl.mob.opencvproject.config.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by manre on 1/11/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
