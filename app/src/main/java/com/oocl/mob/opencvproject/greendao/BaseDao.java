package com.oocl.mob.opencvproject.greendao;

import com.oocl.mob.opencvproject.common.GreenDAOUtils;
import com.oocl.mob.opencvproject.greendao.db.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by manre on 1/19/17.
 */

public abstract class BaseDao<T,K> {


    /**
     * insert entity t
     * @param  t  need to save entity
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public void insert(T t) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class tClazz  = getTClass();
        K k=getDao();
        Class kClazz=getKClass();
        String functionNameForK="insert";
        Method methodK=kClazz.getMethod(functionNameForK,tClazz);
        methodK.invoke(k,t);
    }

    /**
     * query all data for this entity
     * @return list of this entity
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public List<T> queryList() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        K k=getDao();
        Class kClazz=getKClass();
        String functionNameForK="queryBuilder";
        Method methodK=kClazz.getMethod(functionNameForK);
        QueryBuilder<T> qb= (QueryBuilder<T>) methodK.invoke(k);
        List<T>list =qb.list();
        return list;
    }

    /**
     * get this Entity mapping dao class
     *
     * @return  T mapping's entity.
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public K getDao() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DaoSession daoSession=GreenDAOUtils.getmInstance().getWritableDaoSession();
        Class clazz=daoSession.getClass();
        Class tClazz  = getTClass();
        String functionNameForSession="get"+tClazz.getSimpleName()+"Dao";
        Method method=clazz.getDeclaredMethod(functionNameForSession);
        K k=(K)method.invoke(daoSession);
        return k;
    }

    /**
     * delete entity
     * @param t  entity
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void delete(T t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class tClazz  = getTClass();
        K k=getDao();
        Class kClazz=getKClass();
        String functionNameForK="delete";
        Method methodK=kClazz.getMethod(functionNameForK,tClazz);
        methodK.invoke(k,t);
    }


    public void update(T t)throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Class tClazz  = getTClass();
        K k=getDao();
        Class kClazz=getKClass();
        String functionNameForK="update";
        Method methodK=kClazz.getMethod(functionNameForK,tClazz);
        methodK.invoke(k,t);
    }



    /**
     * get T class entity
     * @param <T>
     * @return
     */
    public  <T>  Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * get K class entity mapping class
     * @param <K>
     * @return
     */
    public <K> Class<K> getKClass(){
        return (Class<K>)((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
