package com.oocl.mob.opencvproject.ViewActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oocl.mob.opencvproject.R;
import com.oocl.mob.opencvproject.R2;
import com.oocl.mob.opencvproject.ViewController.LoginController;
import com.oocl.mob.opencvproject.ViewModel.UserModel;
import com.oocl.mob.opencvproject.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMVCActivity extends AppCompatActivity {

    @BindView(R2.id.afterLoginUserName)
    TextView afterLoginUserName;

    @BindView(R2.id.afterLoginUserPassword)
    TextView afterLoginUserPassword;

    @BindView(R2.id.saveUser)
    Button saveUserBtn;

    private LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mvc);
        ButterKnife.bind(this);
        init(savedInstanceState);
        loginController=new LoginController();
        List<User> users=loginController.getUserList();
        Log.i("user",users.toString());

    }
    private void init(Bundle savedInstanceState){
        UserModel userModel=(UserModel)getIntent().getParcelableExtra("UserModelLogin");

        if(userModel!=null)
        {
            afterLoginUserName.setText(userModel.getUserName());
            afterLoginUserPassword.setText(userModel.getUserPassword());
            saveUserBtn.setEnabled(true);
        }else{
            saveUserBtn.setEnabled(false);
        }
    }
    @OnClick(R2.id.saveUser) void saveUserBtn(View view)
    {
        UserModel userModel=new UserModel();
        userModel.setUserName(afterLoginUserName.getText().toString());
        userModel.setUserPassword(afterLoginUserPassword.getText().toString());
        loginController.saveUserinformation(userModel);
    }


}
