package com.andycode.tablayout.entidades;

import java.io.Serializable;

public class ComponenteVo implements Serializable {

    //Atributos de la clase ComponenteVo
    private String nombreComponente;
    private String infoComponente;
    private Integer imagenComponente;

    //Metodo constructor para inicializar atributos
    public ComponenteVo(String nombreComponente, String infoComponente, Integer imagenComponente) {

        this.nombreComponente = nombreComponente;
        this.infoComponente = infoComponente;
        this.imagenComponente = imagenComponente;
    }

    //Constructor vacio
    public ComponenteVo() {
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public String getInfoComponente() {
        return infoComponente;
    }

    public void setInfoComponente(String infoComponente) {
        this.infoComponente = infoComponente;
    }

    public Integer getImagenComponente() {
        return imagenComponente;
    }

    public void setImagenComponente(Integer imagenComponente) {
        this.imagenComponente = imagenComponente;
    }
}