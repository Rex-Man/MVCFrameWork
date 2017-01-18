package com.oocl.mob.opencvproject.ViewController;

import com.oocl.mob.opencvproject.Service.LoginService;
import com.oocl.mob.opencvproject.ViewModel.UserModel;
import com.oocl.mob.opencvproject.model.User;

import org.opencv.ml.Boost;

import java.io.IOException;

/**
 * Created by manre on 1/13/17.
 */

public class LoginController {

    public boolean checkUserInformation(String userName,String userPassword) throws IOException {
        boolean returnvalue=false;

        LoginService loginService=new LoginService();
        User user=loginService.CheckUserInformation(userName,userPassword);
        if(user!=null)
        {
            returnvalue=true;
        }
        else{
            returnvalue=false;
        }

        return returnvalue;
    }
}
