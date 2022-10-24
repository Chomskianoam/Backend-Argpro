package com.portfolio.rim.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Descripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreD;
    private String ubicacionD;
    private String puestoD;
    private String infoD;
    private String infosD;
    private String imgfondoD;
    private String imgperfilD;

    //Constructores
    
    public Descripcion() {
    }

    public Descripcion(String nombreD, String ubicacionD, String puestoD, String infoD, String infosD, String imgfondoD, String imgperfilD) {
        this.nombreD = nombreD;
        this.ubicacionD = ubicacionD;
        this.puestoD = puestoD;
        this.infoD = infoD;
        this.infosD = infosD;
        this.imgfondoD = imgfondoD;
        this.imgperfilD = imgperfilD;
    }
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
