package com.oocl.mob.opencvproject.ViewActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.mob.opencvproject.EventClass.MyEventClass;
import com.oocl.mob.opencvproject.EventClass.UserEventClass;
import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;
import com.oocl.mob.opencvproject.ViewController.LoginController;
import com.oocl.mob.opencvproject.ViewModel.UserModel;
import com.oocl.mob.opencvproject.common.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    private final String Tag="MVC FrameWork";

    @BindView(R2.id.usernameET)
    TextView userNameET;
    @BindView(R2.id.userPasswordET)
    TextView userPasswordET;

    private LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EventBusUtils.register(this);
        ButterKnife.bind(this);
        loginController=new LoginController();
    }
    @OnClick(R2.id.userLogin) void LoginFunction()
    {
        try {
            loginController.checkUserInformation(userNameET.getText().toString(),userPasswordET.getText().toString());
        } catch (IOException e) {
            Log.e(Tag,"Login Exception",e);

        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1)
    public void messagePriorityOneEvent(UserEventClass event)
    {
        if(event.getUserModel()!=null)
        {
            Intent intent=new Intent(this,MainMVCActivity.class);
            UserModel userModel=new UserModel();
            userModel.setUserName(userNameET.getText().toString());
            userModel.setUserPassword(userPasswordET.getText().toString());
            intent.putExtra("UserModelLogin",userModel);
            startActivity(intent);
        }else{
            String message="Your User name or password may be not correct! Please try again.";
            if(event.getErrorMessage()!=null && !event.getErrorMessage().isEmpty()) {
                message=event.getErrorMessage();
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }

}
