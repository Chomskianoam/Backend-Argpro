
package com.portfolio.rim.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String lenguajeP;
    private String descripcionP;
    private String imgP; 

    //Constructores
    public Proyecto() {
    }

    public Proyecto(String nombreP, String lenguajeP, String descripcionP, String imgP) {
        this.nombreP = nombreP;
        this.lenguajeP = lenguajeP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }
   
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getLenguajeP() {
        return lenguajeP;
    }

    public void setLenguajeP(String lenguajeP) {
        this.lenguajeP = lenguajeP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
    
}
