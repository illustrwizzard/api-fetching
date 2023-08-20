package com.example.retrfitex.FetchData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstanceNew {
    public static String baseUrlNew="https://api.publicapis.org/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrlNew)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
