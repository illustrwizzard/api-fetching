package com.example.retrfitex.insert;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface insertapi {
    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("db_insert.php")
    //Call<insertmodel> adddata(@Body String body);
    Call<insertmodel> adddata(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password);
}
