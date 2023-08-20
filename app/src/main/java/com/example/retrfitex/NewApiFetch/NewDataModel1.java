package com.example.retrfitex.NewApiFetch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewDataModel1 {
    @SerializedName("products")
    private List<NewProductsList> newProductsLists;

    public NewDataModel1(List<NewProductsList> newProductsLists) {
        this.newProductsLists = newProductsLists;
    }

    public List<NewProductsList> getNewProductsLists() {
        return newProductsLists;
    }

    public void setNewProductsLists(List<NewProductsList> newProductsLists) {
        this.newProductsLists = newProductsLists;
    }
}
