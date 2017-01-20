package com.oocl.mob.opencvproject.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by manre on 1/16/17.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String userName;
    private String userPassword;
    private int age;

    @Generated(hash = 1448001813)
    public User(Long id, String userName, String userPassword, int age) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
