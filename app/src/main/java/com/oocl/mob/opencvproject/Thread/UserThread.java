package com.oocl.mob.opencvproject.Thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.oocl.mob.opencvproject.Service.LoginService;
import com.oocl.mob.opencvproject.ViewModel.UserModel;
import com.oocl.mob.opencvproject.model.User;

/**
 * Created by manre on 1/18/17.
 */

public class UserThread extends Thread {
    private String userName;
    private String userPassword;
    private Handler myHandler;


    public UserThread()
    {

    }
    public UserThread(String userName,String userPassword ,Handler myHandler)
    {
        this.userName=userName;
        this.userPassword=userPassword;
        this.myHandler=myHandler;
    }
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public void run() {
        UserModel userModel=null;

        try {
            LoginService loginService = new LoginService();
            User user = loginService.CheckUserInformation(userName, userPassword);
            if(user!=null) {
                userModel = new UserModel();
                userModel.setUserName(user.getUserName());
                userModel.setUserPassword(user.getUserPassword());
            }

        }catch (Exception e)
        {
            Log.e("LoginController","Runnable have issue",e.getCause());
        }

        Bundle bundle=new Bundle();
        bundle.putParcelable("userLoginInfor",userModel);
        Message message=new Message();
        message.what=0x123;
        message.setData(bundle);
        myHandler.sendMessage(message);
    }
}
