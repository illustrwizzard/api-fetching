package com.example.retrfitex.FetchData;

public class DataModelFetch {
    String API,Description,Link;

    public DataModelFetch(String API, String description, String link) {
        this.API = API;
        Description = description;
        Link = link;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
