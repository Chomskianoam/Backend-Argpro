
package com.portfolio.rim.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String tituloEd;
    private String yearEd;
    private String imgEd;

    //Constructores
    public Educacion() {
    }

    public Educacion(String nombreEd, String tituloEd, String yearEd, String imgEd) {
        this.nombreEd = nombreEd;
        this.tituloEd = tituloEd;
        this.yearEd = yearEd;
        this.imgEd = imgEd;
    }
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
