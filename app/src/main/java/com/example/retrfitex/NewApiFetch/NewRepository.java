package com.example.retrfitex.NewApiFetch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewRepository {
    private NewApiFetch newApiFetch;

    public NewRepository(){
        newApiFetch=NewRetrofitClient.getRetrofitInstance().create(NewApiFetch.class);

    }

    public LiveData<List<NewProductsList>> getProducts(){
        MutableLiveData<List<NewProductsList>> data=new MutableLiveData<>();
        newApiFetch.getProductLists().enqueue(new Callback<List<NewProductsList>>() {
            @Override
            public void onResponse(Call<List<NewProductsList>> call, Response<List<NewProductsList>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NewProductsList>> call, Throwable t) {
                data.postValue(null);

            }
        });

        return data;
    }

}
