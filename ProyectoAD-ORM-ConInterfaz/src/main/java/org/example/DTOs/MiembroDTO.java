package org.example.DTOs;

import java.util.Date;

public class MiembroDTO {
    private String nombreCompleto;
    private String telefono;
    private Integer handicap;
    private Date fechaIngreso;
    private String genero;

    public MiembroDTO(String nombreCompleto, String telefono, Integer handicap, Date fechaIngreso, String genero) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.handicap = handicap;
        this.fechaIngreso = fechaIngreso;
        this.genero = genero;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
