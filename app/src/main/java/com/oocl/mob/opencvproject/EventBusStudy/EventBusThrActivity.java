package com.oocl.mob.opencvproject.EventBusStudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.oocl.mob.opencvproject.EventClass.MyEventClass5;
import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;
import com.oocl.mob.opencvproject.common.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusThrActivity extends AppCompatActivity {
    @BindView(R2.id.txtShow)
    TextView textView;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_thr);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        EventBusUtils.removeAllStickyEvents();
        EventBusUtils.unregister(this);
        super.onDestroy();
    }
    @OnClick(R2.id.stickBtn) void stickButton()
    {
        if(flag)
        {
            EventBusUtils.register(this);
            flag=false;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky=true)
    public void StickMessage(MyEventClass5 stickEvent)
    {
        textView.setText(stickEvent.message);
    }
}
