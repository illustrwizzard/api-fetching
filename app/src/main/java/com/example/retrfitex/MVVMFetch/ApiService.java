package com.example.retrfitex.MVVMFetch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("entries")
    Call<ApiResponse> getApiEntries();
}
