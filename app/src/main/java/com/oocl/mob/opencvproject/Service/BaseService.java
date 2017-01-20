package com.oocl.mob.opencvproject.Service;

import com.oocl.mob.opencvproject.greendao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manre on 1/16/17.
 */

public class BaseService<T>  {

    Map<Class<T>,Retrofit>  mainClassMapnew = new HashMap<>();
    Retrofit retrofit;
    protected Retrofit getRetrofit(Class<T> classType)
    {
      if(mainClassMapnew.get(classType)!=null)
        {
            retrofit=mainClassMapnew.get(classType);
        }else{
            retrofit= new Retrofit.Builder()
                  .baseUrl("http://manre-3-w7.corp.oocl.com:8080/TestServer/")
                    .addConverterFactory(GsonConverterFactory.create())
                  .build();
          mainClassMapnew.put(classType,retrofit);
        }
        return retrofit;
    }
    protected T createObject(Class<T> classType)
    {
        return getRetrofit(classType).create(getTClass());
    }
    private Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }


}
