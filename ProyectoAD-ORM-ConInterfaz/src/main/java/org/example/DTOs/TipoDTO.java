package org.example.DTOs;

public class TipoDTO {
    private String tipo;
    private int tarifa;

    public TipoDTO(String tipo, int tarifa) {
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
}