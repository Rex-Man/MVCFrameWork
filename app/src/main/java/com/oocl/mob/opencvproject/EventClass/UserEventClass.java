package com.oocl.mob.opencvproject.EventClass;

import com.oocl.mob.opencvproject.ViewModel.UserModel;

/**
 * Created by manre on 1/18/17.
 */

public class UserEventClass {
    private UserModel userModel;
    private String statusCode;
    private String errorMessage;
    public UserEventClass()
    {

    }
    public UserEventClass(UserModel userModel)
    {
        this.userModel=userModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
