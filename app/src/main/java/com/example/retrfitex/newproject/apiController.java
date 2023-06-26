package com.example.retrfitex.newproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {
    private static final String urlcode="http://192.168.18.75/api/";
    private static apiController clientobject;
    private static Retrofit retrofit;

    apiController(){
        retrofit=new Retrofit.Builder()
                .baseUrl(urlcode)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apiController getInstance(){
        if (clientobject==null){
            clientobject=new apiController();
        }
        return clientobject;
    }
   public apiset getapi(){
        return retrofit.create(apiset.class);
    }
}
