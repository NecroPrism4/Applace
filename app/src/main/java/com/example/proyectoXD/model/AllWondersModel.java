package com.example.proyectoXD.model;

public class AllWondersModel {

    Integer id;
    Integer imageurl;
    String Nombre;
    String Descripcion;
    String urlPagina;

    public AllWondersModel(Integer id, Integer imageurl, String nombre, String descripcion, String urlPagina) {
        this.id = id;
        this.imageurl = imageurl;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.urlPagina = urlPagina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public String getNombre() { return Nombre; }

    public void setNombre(String nombre) { this.Nombre = nombre; }

    public String getDescripcion() { return Descripcion; }

    public void setDescripcion(String descripcion) { Descripcion = descripcion; }

    public String getUrlPagina() { return urlPagina; }

    public void setUrlPagina(String urlPagina) { this.urlPagina = urlPagina; }
}
