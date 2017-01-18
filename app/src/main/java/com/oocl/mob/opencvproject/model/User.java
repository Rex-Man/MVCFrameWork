package com.oocl.mob.opencvproject.model;

/**
 * Created by manre on 1/16/17.
 */

public class User {
    private String userName;
    private String userPassword;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
