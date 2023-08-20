package com.example.retrfitex.insert;

public class fetchdatamodel {
    String id, title,username,password, image;


    public fetchdatamodel() {
    }

    public fetchdatamodel(String id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image =image;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
