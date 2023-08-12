package com.example.proyectoXD.model;

public class Wonders {

    Integer id;
    Integer imageurl;
    String nombreWonderPrin;

    public Wonders(Integer id, Integer imageurl, String nombreWonderPrin) {
        this.id = id;
        this.imageurl = imageurl;
        this.nombreWonderPrin = nombreWonderPrin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() { return imageurl; }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public String getNombreWonderPrin() { return nombreWonderPrin; }

    public void setNombreWonderPrin(String nombreWonderPrin) { this.nombreWonderPrin = nombreWonderPrin; }

}
