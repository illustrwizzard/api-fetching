package com.example.retrfitex.insert.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrfitex.insert.RetroInstance;
import com.example.retrfitex.insert.fetchdatamodel;
import com.example.retrfitex.newproject.apiController;
import com.example.retrfitex.newproject.apiset;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class myviewmodel extends ViewModel {
    private MutableLiveData<List<fetchdatamodel>> fetchlist;
    public myviewmodel(){
        fetchlist=new MutableLiveData<>();
    }
    public MutableLiveData<List<fetchdatamodel>> getDataObserver(){
        return fetchlist;
    }

    public void makeApiCall(){
        apiset apisetcall= RetroInstance.getRetroClient().create(apiset.class);
        Call<List<fetchdatamodel>> call=apisetcall.getdata();
        call.enqueue(new Callback<List<fetchdatamodel>>() {
            @Override
            public void onResponse(Call<List<fetchdatamodel>> call, Response<List<fetchdatamodel>> response) {
                fetchlist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<fetchdatamodel>> call, Throwable t) {
                fetchlist.postValue(null);


            }
        });

    }
}
