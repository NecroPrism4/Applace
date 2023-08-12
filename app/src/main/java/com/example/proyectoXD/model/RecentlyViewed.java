package com.example.proyectoXD.model;

public class RecentlyViewed {

    String name;
    String description;
    String extradescription;
    String lugaresmethod;
    String idmethod;
    int imageUrl;
    int bigimageurl;

    public RecentlyViewed(String name, String description, String extradescription, String lugaresmethod, String idmethod, int
            imageUrl, int bigimageurl) {
        this.name = name;
        this.description = description;
        this.extradescription = extradescription;
        this.lugaresmethod = lugaresmethod;
        this.idmethod = idmethod;
        this.imageUrl = imageUrl;
        this.bigimageurl = bigimageurl;
    }

    public int getBigimageurl() {
        return bigimageurl;
    }

    public void setBigimageurl(int bigimageurl) {
        this.bigimageurl = bigimageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtradescription() {
        return extradescription;
    }

    public void setExtradescription(String extradescription) {
        this.extradescription = extradescription;
    }

    public String getLugaresmethod() {
        return lugaresmethod;
    }

    public void setLugaresmethod(String lugaresmethod) {
        this.lugaresmethod = lugaresmethod;
    }

    public String getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(String idmethod) {
        this.idmethod = idmethod;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
