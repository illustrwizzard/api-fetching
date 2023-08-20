package com.example.retrfitex.MVVMFetch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private ApiService apiService;

    public ApiRepository() {
        apiService = RetrofitClient.getInstance().create(ApiService.class);
    }

    public LiveData<List<ApiEntry>> getApiEntries() {
        MutableLiveData<List<ApiEntry>> data = new MutableLiveData<>();
        apiService.getApiEntries().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body().getEntries());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle failure
            }
        });
        return data;
    }
}
