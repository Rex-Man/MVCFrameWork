package com.oocl.mob.opencvproject.greendao;

import com.oocl.mob.opencvproject.common.GreenDAOUtils;
import com.oocl.mob.opencvproject.greendao.db.DaoMaster;
import com.oocl.mob.opencvproject.greendao.db.DaoSession;
import com.oocl.mob.opencvproject.greendao.db.UserDao;
import com.oocl.mob.opencvproject.model.User;

import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by manre on 1/20/17.
 */

public class UserDaoImpl extends BaseDao<User,UserDao> {

    public void insert(User user)
    {

//        DaoSession daoSession= GreenDAOUtils.getmInstance().getWritableDaoSession();
//        UserDao userDao=daoSession.getUserDao();
//        userDao.insert(user);

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
    public List<User> queryUserList(){
//        DaoSession daoSession= GreenDAOUtils.getmInstance().getWritableDaoSession();
//        UserDao userDao=daoSession.getUserDao();
//        QueryBuilder<User> qb=userDao.queryBuilder();
//        List<User> list=qb.list();
//        return list;
        List<User> list=null;
        try {
            list=  super.queryList();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
     return list;

    }
    public void deleteUser(User user)
    {
        try {
//            UserDao userDao=super.getDao();
//            userDao.delete(user);
            super.delete(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User user)
    {
        UserDao userDao= null;
        try {
            userDao = super.getDao();
            userDao.update(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
