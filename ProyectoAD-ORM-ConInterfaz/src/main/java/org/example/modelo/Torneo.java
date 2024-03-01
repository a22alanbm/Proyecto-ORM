package org.example.modelo;

public class Torneo {
    // Representa la tabla 'Tournament' en la base de datos
    private int idTorneo;            // Corresponde al atributo 'TourID' en la tabla
    private String nombreTorneo;     // Corresponde al atributo 'TourName' en la tabla
    private String tipoTorneo;       // Corresponde al atributo 'TourType' en la tabla

    // Constructores, getters, setters y otros métodos pueden agregarse aquí

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
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

    // Ejemplo de constructor
    public Torneo(int idTorneo, String nombreTorneo, String tipoTorneo) {
        this.idTorneo = idTorneo;
        this.nombreTorneo = nombreTorneo;
        this.tipoTorneo = tipoTorneo;
    }

    public Torneo() {
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "idTorneo=" + idTorneo +
                ", nombreTorneo='" + nombreTorneo + '\'' +
                ", tipoTorneo='" + tipoTorneo + '\'' +
                '}';
    }
}