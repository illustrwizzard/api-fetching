package com.example.retrfitex.insert;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String baseurl="http://192.168.18.75/api/";
    private static Retrofit retrofit;
    public static Retrofit getRetroClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
