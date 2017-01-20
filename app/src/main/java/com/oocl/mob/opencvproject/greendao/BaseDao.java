package com.oocl.mob.opencvproject.greendao;

import com.oocl.mob.opencvproject.common.GreenDAOUtils;
import com.oocl.mob.opencvproject.greendao.db.DaoSession;

import org.greenrobot.greendao.AbstractDao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * Created by manre on 1/19/17.
 */

public abstract class BaseDao<T,K> {






    public void insert(T t) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

//            Class tClazz  = getTClass();
//            AbstractDao dao=GreenDAOUtils.getmInstance().getWritableDaoSession().getDao(tClazz);
//            Class clazz=  dao.getClass();
//            // get function name;
//            String functionName="get"+tClazz.getSimpleName()+"Dao";
//            Method method=clazz.getDeclaredMethod(functionName);
//            method.invoke(dao,t);

        DaoSession daoSession=GreenDAOUtils.getmInstance().getWritableDaoSession();
        Class clazz=daoSession.getClass();
        Class tClazz  = getTClass();
        String functionNameForSession="get"+tClazz.getSimpleName()+"Dao";
        Method method=clazz.getDeclaredMethod(functionNameForSession);
        K k=(K)method.invoke(daoSession);
        Class kClazz=getKClass();
        String functionNameForK="insert";
        Method methodK=kClazz.getDeclaredMethod(functionNameForK);
        methodK.invoke(k,t);
    }










    // Get T class
    public  <T>  Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

    }
    public <K> Class<K> getKClass(){
        return (Class<K>)((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
