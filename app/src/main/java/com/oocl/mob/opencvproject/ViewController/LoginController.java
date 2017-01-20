package com.oocl.mob.opencvproject.ViewController;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.oocl.mob.opencvproject.EventClass.UserEventClass;
import com.oocl.mob.opencvproject.Service.LoginService;
import com.oocl.mob.opencvproject.Thread.UserThread;
import com.oocl.mob.opencvproject.ViewModel.UserModel;
import com.oocl.mob.opencvproject.common.EventBusUtils;
import com.oocl.mob.opencvproject.model.User;

import org.opencv.ml.Boost;

import java.io.IOException;

/**
 * Created by manre on 1/13/17.
 */

public class LoginController {



    public void checkUserInformation(String userName,String userPassword) throws IOException {

         Handler myHandler =new Handler(){
                @Override
                public void handleMessage(Message msg) {

                if(msg.what==0x123) {
                    UserModel userModel = msg.getData().getParcelable("userLoginInfor");

                    EventBusUtils.post(new UserEventClass(userModel));
                }
            }
        };


        UserThread runnable=new UserThread(userName,userPassword,myHandler);
        runnable.start();
    }
}
