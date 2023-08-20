package com.example.retrfitex.NewApiFetch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewRetrofitClient {

    private static final String BASE_URL="https://dummyjson.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
