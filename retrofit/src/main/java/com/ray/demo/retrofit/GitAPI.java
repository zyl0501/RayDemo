package com.ray.demo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ray on 16/3/10.
 */
public interface GitAPI {
    @GET("/users/{user}")      // here is the other url part.best way is to start using /
    Call<GitModel> getFeed(@Path("user") String user);
    // string user is for passing values from edittext for eg: user=basil2style,google
    // response is the response from the server which is now in the POJO
}
