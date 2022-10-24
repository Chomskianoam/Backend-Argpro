
package com.portfolio.rim.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String lenguajeP;
    private String imgP;
    
    //Constructores

    public dtoProyecto() {
    }
    
    public dtoProyecto(String nombreP, String lenguajeP) {
        this.nombreP = nombreP;
        this.lenguajeP = lenguajeP;
    }
    
    //Getters & Setters
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLenguajeP() {
        return lenguajeP;
    }

    public void setLenguajeP(String lenguajeP) {
        this.lenguajeP = lenguajeP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
     
}
