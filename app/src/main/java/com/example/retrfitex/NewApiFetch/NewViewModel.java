package com.example.retrfitex.NewApiFetch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NewViewModel extends ViewModel {
    private NewRepository newRepository;
    private LiveData<List<NewProductsList>> newProductList;

    public NewViewModel(){
        newRepository=new NewRepository();
        newProductList=newRepository.getProducts();
    }

    public LiveData<List<NewProductsList>> getNewProductList(){
        return newProductList;
    }
}
