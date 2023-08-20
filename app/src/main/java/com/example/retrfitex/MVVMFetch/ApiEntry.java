package com.example.retrfitex.MVVMFetch;

import com.google.gson.annotations.SerializedName;

public class ApiEntry {

        @SerializedName("API")
        private String api;
        @SerializedName("Description")
        private String description;
        @SerializedName("Link")
        private String link;

    public ApiEntry(String api, String description, String link) {
        this.api = api;
        this.description = description;
        this.link = link;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // Getters and setters


}
