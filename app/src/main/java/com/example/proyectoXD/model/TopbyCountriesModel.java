package com.example.proyectoXD.model;

public class TopbyCountriesModel {

    public void setLinkGoogleTravel(String linkGoogleTravel) {
        LinkGoogleTravel = linkGoogleTravel;
    }

    Integer Imageurl;
    String TopCountryName;
    String TopCountryDesc;
    String LinkwhitMoreInfoTopCountry;
    String LinkGoogleTravel;
    String LinkYoutubeTopPais;

    /*public TopbyCountriesModel(Integer id, Integer imageurl, String topCountryName) {
        this.id = id;
        this.Imageurl = imageurl;
        this.TopCountryName = topCountryName;
    }*/

    public TopbyCountriesModel(Integer imageurl, String topCountryName, String topCountryDesc, String linkwhitMoreInfoTopCountry, String linkGoogleTravel,String linkYoutubeTopPais) {
        this.Imageurl = imageurl;
        this.TopCountryName = topCountryName;
        this.TopCountryDesc = topCountryDesc;
        this.LinkwhitMoreInfoTopCountry = linkwhitMoreInfoTopCountry;
        this.LinkGoogleTravel = linkGoogleTravel;
        this.LinkYoutubeTopPais = linkYoutubeTopPais;
    }

    public Integer getImageurl() { return Imageurl; }

    public void setImageurl(Integer imageurl) { Imageurl = imageurl; }

    public String getTopCountryName() { return TopCountryName; }

    public void setTopCountryName(String topCountryName) { TopCountryName = topCountryName; }

    public String getTopCountryDesc() { return TopCountryDesc; }

    public void setTopCountryDesc(String topCountryDesc) { TopCountryDesc = topCountryDesc; }

    public String getLinkwhitMoreInfoTopCountry() { return LinkwhitMoreInfoTopCountry; }

    public void setLinkwhitMoreInfoTopCountry(String linkwhitMoreInfoTopCountry) { LinkwhitMoreInfoTopCountry = linkwhitMoreInfoTopCountry; }

    public String getLinkGoogleTravel() { return LinkGoogleTravel; }

    public void setLinkYoutubeTopPais(String linkYoutubeTopPais) { LinkYoutubeTopPais = linkYoutubeTopPais; }

    public String getLinkYoutubeTopPais() { return LinkYoutubeTopPais; }
}

