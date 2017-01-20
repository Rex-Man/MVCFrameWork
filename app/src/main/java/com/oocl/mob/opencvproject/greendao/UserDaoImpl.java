package com.oocl.mob.opencvproject.greendao;

import com.oocl.mob.opencvproject.greendao.db.UserDao;
import com.oocl.mob.opencvproject.model.User;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by manre on 1/20/17.
 */

public class UserDaoImpl extends BaseDao<User,UserDao> {

    public void insert(User user)
    {
        try {
             super.insert(user);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
