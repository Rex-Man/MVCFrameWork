package com.oocl.mob.opencvproject.ViewActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;
import com.oocl.mob.opencvproject.ViewController.LoginController;
import com.oocl.mob.opencvproject.ViewModel.UserModel;

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
        ButterKnife.bind(this);
        loginController=new LoginController();
    }
    @OnClick(R2.id.userLogin) void LoginFunction()
    {
        String showMessage="";
        try {
            boolean checkResult=loginController.checkUserInformation(userNameET.getText().toString(),userPasswordET.getText().toString());
            if(checkResult)
            {
                Intent intent=new Intent(LoginActivity.this,MainMVCActivity.class);
                Bundle bundle=new Bundle();
                UserModel userModel=new UserModel();
                userModel.setUserName(userNameET.getText().toString());
                userModel.setUserPassword(userPasswordET.getText().toString());
                bundle.putParcelable("UserModel",userModel);
                intent.putExtras(bundle);
                startActivity(intent);
            }else{
                showMessage="User Name or User Password are not correct.";
            }
        } catch (IOException e) {
            Log.e(Tag,"Login Exception",e);

        }
        if (!showMessage.isEmpty())
        {
            Toast.makeText(this,showMessage,Toast.LENGTH_SHORT).show();
        }
    }

}
