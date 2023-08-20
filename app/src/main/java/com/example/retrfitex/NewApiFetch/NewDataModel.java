package com.example.retrfitex.NewApiFetch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewDataModel {
    @SerializedName("carts")
    private List<NewDataModel1> newDataModel1s;

    public NewDataModel(List<NewDataModel1> newDataModel1s) {
        this.newDataModel1s = newDataModel1s;
    }

    public List<NewDataModel1> getNewDataModel1s() {
        return newDataModel1s;
    }

    public void setNewDataModel1s(List<NewDataModel1> newDataModel1s) {
        this.newDataModel1s = newDataModel1s;
    }
}
