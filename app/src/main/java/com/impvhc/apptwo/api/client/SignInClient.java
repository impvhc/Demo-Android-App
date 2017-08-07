package com.impvhc.apptwo.api.client;

import com.impvhc.apptwo.model.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by victor on 8/7/17.
 */

public interface SignInClient {
    @GET("login")
    Observable<User> signIn(@Query("username") String username, @Query("password") String password);
}
