package com.islonline.mobile.testapplication.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("webapi2")
    Call<UserRes> getSid(@Query("method") String method, @Body User user);
}
