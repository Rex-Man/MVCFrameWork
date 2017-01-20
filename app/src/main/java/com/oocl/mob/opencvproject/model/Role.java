package com.oocl.mob.opencvproject.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by manre on 1/19/17.
 */
@Entity
public class Role {
    @Id(autoincrement = true)
    private Long id;
    private String roleName;

    @Generated(hash = 1161883333)
    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Generated(hash = 844947497)
    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
