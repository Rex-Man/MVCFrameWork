package com.oocl.mob.opencvproject.EventBusStudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusSedActivity extends AppCompatActivity {

    @BindView(R2.id.welcomeTV)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_sed);
        ButterKnife.bind(this);
        textView.setText("Second EventBus Activity");

    }

    @OnClick(R2.id.firstActivity) void translateActivity()
    {
        //Intent intent = new Intent(EventBusSedActivity.this,EventBusMainActivity.class);
        EventBusUtils.post(new MyEventClass("Oh,yes class1!"));
        EventBusUtils.post(new MyEventClass2("Oh,yes class2!"));
        EventBusUtils.post(new MyEventClass3("Oh,yes class3!"));
        EventBusUtils.post(new MyEventClass4("Oh,yes class4!"));
        //startActivity(intent);
    }
    @OnClick(R2.id.thireActivity) void turnToStrickActivity()
    {
        EventBusUtils.postSticky(new MyEventClass5("this is from second activity message"));
        Intent intent = new Intent(EventBusSedActivity.this,EventBusThrActivity.class);
        startActivity(intent);
    }


}
