package com.oocl.mob.opencvproject.ViewModel;

import android.os.Parcel;
import android.os.Parcelable;



/**
 * Created by manre on 1/13/17.
 */

public class UserModel implements Parcelable{
    private String userName;
    private String userPassword;

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(userPassword);

    }
    public static final Parcelable.Creator<UserModel> CREATOR=new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel parcel) {
            UserModel user =new UserModel();
            user.setUserName(parcel.readString());
            user.setUserPassword(parcel.readString());
            return user;
        }

        @Override
        public UserModel[] newArray(int i) {
            return new UserModel[0];
        }
    };

}
