package com.portfolio.rim.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String tituloEd;
    @NotBlank
    private String yearEd;
    private String imgEd;
    
    //Constructores
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String tituloEd, String yearEd, String imgEd) {
        this.nombreEd = nombreEd;
        this.tituloEd = tituloEd;
        this.yearEd = yearEd;
        this.imgEd = imgEd;
    }
    
    //Getters & Setters

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getYearEd() {
        return yearEd;
    }

    public void setYearEd(String yearEd) {
        this.yearEd = yearEd;
    }

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }
    
    
}
