package com.oocl.mob.opencvproject.Service.Retrofit;

import com.oocl.mob.opencvproject.model.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by manre on 1/16/17.
 */

public interface LoginServiceImpl {

    @POST("user")
    Call<User> checkUserInformation(@Query("userName") String userName, @Query("userPassword") String userPassword);


}
