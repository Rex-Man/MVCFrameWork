package com.oocl.mob.opencvproject.EventBusStudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.mob.opencvproject.EventClass.MyEventClass;
import com.oocl.mob.opencvproject.EventClass.MyEventClass2;
import com.oocl.mob.opencvproject.EventClass.MyEventClass3;
import com.oocl.mob.opencvproject.EventClass.MyEventClass4;
import com.oocl.mob.opencvproject.EventClass.MyEventClass5;
import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;
import com.oocl.mob.opencvproject.common.EventBusUtils;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusMainActivity extends AppCompatActivity {

    @BindView(R2.id.firstTextView)TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_main);
        EventBusUtils.register(this);
        ButterKnife.bind(this);

        //textView.setText("first Text");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        EventBusUtils.unregister(this);

    }
    //PRIORITY 越大，越先执行
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1)
    public void messagePriorityOneEvent(MyEventClass event)
    {
        textView.setText("Back from Second Activity priority=1");
        Log.i("EventBusTestLog","this is priority is one function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 4)
    public void messagePriorityZeroEvent(MyEventClass event)
    {
        textView.setText("Back from Second Activity priority=0");
        Log.i("EventBusTestLog","this is priority is zero function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void messagePostingEvent(MyEventClass2 event)
    {
        textView.setText("Back from post Second Activity");
        Log.i("EventBusTestLog","this is post  function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void messageAsyncEvent(MyEventClass3 event)
    {
        textView.setText("Back from Async econd Activity");
        Log.i("EventBusTestLog","this is ASYNC  function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void messageBackgroundEvent(MyEventClass4 event)
    {
        textView.setText("Back from Second Activity");
        Log.i("EventBusTestLog","this is background  function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageBackgroundEvent(MyEventClass5 event)
    {
        textView.setText("Back from 5Second Activity");
        Log.i("EventBusTestLog","this is background  function thread:"+Thread.currentThread());
        Toast.makeText(this,event.message,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R2.id.ShowSecondBtn) void showSecondBtn(){
        Intent intent=new Intent(EventBusMainActivity.this,EventBusSedActivity.class);
        startActivity(intent);
    }

}
