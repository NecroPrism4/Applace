package com.example.proyectoXD.model;

import android.net.Uri;

public class loginCredentials {

    public static Boolean Iniciado;

    public static Uri ImagenPerfil;

    public loginCredentials(Boolean iniciado, Uri imagenPerfil) {
        this.Iniciado = iniciado;
        this.ImagenPerfil = imagenPerfil;
    }

    public static Boolean getIniciado() { return Iniciado; }

    public static void setIniciado(Boolean iniciado) { Iniciado = iniciado; }

    public static Uri getImagenPerfil() { return ImagenPerfil; }

    public static void setImagenPerfil(Uri imagenPerfil) { ImagenPerfil = imagenPerfil; }
}

//acct.getPhotoUrl()
