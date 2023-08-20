package com.example.retrfitex.newproject;

import com.example.retrfitex.insert.fetchdatamodel;
import com.example.retrfitex.insert.insertmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface apiset {
    @FormUrlEncoded
    @POST("register.php")
    Call<responsemodel>getregister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("db_insert.php")
    Call<responsemodel> adddata(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password);

    @GET("typefetch.php")
    Call<List<fetchdatamodel>> getdata();
}
