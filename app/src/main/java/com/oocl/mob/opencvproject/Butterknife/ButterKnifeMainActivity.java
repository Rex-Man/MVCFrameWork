package com.oocl.mob.opencvproject.Butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ButterKnifeMainActivity extends AppCompatActivity {


    @BindView(R2.id.butterknifeTV)
    TextView butterknifeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_main);
        ButterKnife.bind(this);
        butterknifeTV.setText("ButterKnifeTv");

    }
}
