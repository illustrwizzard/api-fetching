package com.example.retrfitex.FetchData.ViewModell;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrfitex.FetchData.DataModelFetch;
import com.example.retrfitex.FetchData.RetroInstanceNew;
import com.example.retrfitex.FetchData.fetchApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelNew extends ViewModel {
    private MutableLiveData<List<DataModelFetch>> fetchnewdata;
    public ViewModelNew(){
        fetchnewdata=new MutableLiveData<>();
    }

//    public ViewModelNew(MutableLiveData<List<DataModelFetch>> fetchnewdata) {
//        this.fetchnewdata = fetchnewdata;
//    }
    public MutableLiveData<List<DataModelFetch>> getObservernew(){
        return fetchnewdata;
    }

    public void makenewApiCall(){
        fetchApi fetchApis= RetroInstanceNew.getRetrofitClient().create(fetchApi.class);
        Call<List<DataModelFetch>> call=fetchApis.getallnewData();
        call.enqueue(new Callback<List<DataModelFetch>>() {
            @Override
            public void onResponse(Call<List<DataModelFetch>> call, Response<List<DataModelFetch>> response) {
                Log.w("responseee",response.body().toString());
                fetchnewdata.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<DataModelFetch>> call, Throwable t) {
                fetchnewdata.postValue(null);
                Log.w("responseee",t.getMessage().toString());
            }
        });
    }

}
