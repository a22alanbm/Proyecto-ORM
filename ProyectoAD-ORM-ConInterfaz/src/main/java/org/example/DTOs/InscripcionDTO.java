package org.example.DTOs;

public class InscripcionDTO {
    private int idMiembro;
    private int idTorneo;
    private int año;

    public InscripcionDTO(int idMiembro, int idTorneo, int año) {
        this.idMiembro = idMiembro;
        this.idTorneo = idTorneo;
        this.año = año;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}