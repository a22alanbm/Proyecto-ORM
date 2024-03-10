package org.example.DTOs;

public class EquipoDTO {
    private String nombreEquipo;
    private String nombreManager;

    public EquipoDTO(String nombreEquipo, String nombreManager) {
        this.nombreEquipo = nombreEquipo;
        this.nombreManager = nombreManager;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreManager() {
        return nombreManager;
    }

    public void setNombreManager(String nombreManager) {
        this.nombreManager = nombreManager;
    }
}
