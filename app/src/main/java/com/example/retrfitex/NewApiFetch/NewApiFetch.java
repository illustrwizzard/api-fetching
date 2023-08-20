package com.example.retrfitex.NewApiFetch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewApiFetch {

    @GET("carts")
    Call<List<NewProductsList>> getProductLists();
}
