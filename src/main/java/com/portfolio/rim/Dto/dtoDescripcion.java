package com.portfolio.rim.Dto;

import javax.validation.constraints.NotBlank;


public class dtoDescripcion {
    @NotBlank
    private String nombreD;
    private String ubicacionD;
    @NotBlank
    private String puestoD;
    @NotBlank
    private String infoD; 
    private String infosD;
    @NotBlank
    private String imgfondoD;
    @NotBlank
    private String imgperfilD;
    
    //Constructores

    public dtoDescripcion() {
    }

    public dtoDescripcion(String nombreD, String ubicacionD, String puestoD, String infoD, String infosD, String imgfondoD, String imgperfilD) {
        this.nombreD = nombreD;
        this.ubicacionD = ubicacionD;
        this.puestoD = puestoD;
        this.infoD = infoD;
        this.infosD = infosD;
        this.imgfondoD = imgfondoD;
        this.imgperfilD = imgperfilD;
    }
    
    //Getters & Setters

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getUbicacionD() {
        return ubicacionD;
    }

    public void setUbicacionD(String ubicacionD) {
        this.ubicacionD = ubicacionD;
    }

    public String getPuestoD() {
        return puestoD;
    }

    public void setPuestoD(String puestoD) {
        this.puestoD = puestoD;
    }

    public String getInfoD() {
        return infoD;
    }

    public void setInfoD(String infoD) {
        this.infoD = infoD;
    }

    public String getInfosD() {
        return infosD;
    }

    public void setInfosD(String infosD) {
        this.infosD = infosD;
    }

    public String getImgfondoD() {
        return imgfondoD;
    }

    public void setImgfondoD(String imgfondoD) {
        this.imgfondoD = imgfondoD;
    }

    public String getImgperfilD() {
        return imgperfilD;
    }

    public void setImgperfilD(String imgperfilD) {
        this.imgperfilD = imgperfilD;
    }
    
}
