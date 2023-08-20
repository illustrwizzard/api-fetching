package com.example.retrfitex.FetchData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface fetchApi {
    @GET("entries")
    Call<List<DataModelFetch>> getallnewData();

}
