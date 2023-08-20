package com.example.retrfitex.MVVMFetch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ApiViewModel extends ViewModel {

    private ApiRepository apiRepository;
    private LiveData<List<ApiEntry>> apiEntries;

    public ApiViewModel() {
        apiRepository = new ApiRepository();
        apiEntries = apiRepository.getApiEntries();
    }

    public LiveData<List<ApiEntry>> getApiEntries() {
        return apiEntries;
    }

}
