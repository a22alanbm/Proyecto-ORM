package org.example.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Tournament")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TourID")
    private int idTorneo;

    @Column(name = "TourName")
    private String nombreTorneo;

    @Column(name = "TourType")
    private String tipoTorneo;


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