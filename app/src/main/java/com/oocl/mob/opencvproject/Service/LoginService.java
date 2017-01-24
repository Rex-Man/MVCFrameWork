package com.oocl.mob.opencvproject.Service;


import android.service.media.MediaBrowserService;
import android.util.Log;

import com.oocl.mob.opencvproject.Service.Retrofit.LoginServiceImpl;
import com.oocl.mob.opencvproject.greendao.UserDaoImpl;
import com.oocl.mob.opencvproject.model.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

/**
 * Created by manre on 1/13/17.
 */

public class LoginService extends BaseService<LoginServiceImpl> {

    public User CheckUserInformation(String userName,String password) throws IOException {

        LoginServiceImpl loginServiceImpl = createObject(LoginServiceImpl.class);
        Call<User> call = loginServiceImpl.checkUserInformation(userName,password);
        Response<User> userResponse=call.execute();
        return userResponse.body();

//        call.enqueue(new Callback<User>() {
//
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    User user =response.body();
//                    Log.i("",user.getUserPassword());
//
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    Log.e("eooro","asdf",t);
//                }
//            });


    }
    public void SaveUserInformationToServer(User user) throws IOException {
        LoginServiceImpl loginServiceImpl = createObject(LoginServiceImpl.class);
        Call<User> call = loginServiceImpl.createUser(user);
        call.enqueue(new Callback<User>() {

                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user =response.body();
                    Log.i("",user.getUserPassword());

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("eooro","asdf",t);
                }
            });
    }



    public void InsertUser(User user)
    {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.insert(user);
    }

    public List<User> queryUserList()
    {
        UserDaoImpl userDao=new UserDaoImpl();
        return userDao.queryUserList();
    }

}
