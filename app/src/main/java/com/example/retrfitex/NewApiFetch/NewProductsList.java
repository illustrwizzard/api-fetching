package com.example.retrfitex.NewApiFetch;

import com.google.gson.annotations.SerializedName;

public class NewProductsList {

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private String price;

    @SerializedName("quantity")
    private String quantity;

    public NewProductsList(String title, String price, String quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
