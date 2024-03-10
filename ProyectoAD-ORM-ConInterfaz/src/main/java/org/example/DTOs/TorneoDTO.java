package org.example.DTOs;

public class TorneoDTO {
    private String nombreTorneo;
    private String tipoTorneo;

    public TorneoDTO(String nombreTorneo, String tipoTorneo) {
        this.nombreTorneo = nombreTorneo;
        this.tipoTorneo = tipoTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(String tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }
}
