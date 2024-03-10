package org.example.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"Tournament\"")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TourID\"")
    private int idTorneo;

    @Column(name = "\"TourName\"")
    private String nombreTorneo;

    @Column(name = "\"TourType\"")
    private String tipoTorneo;

    @ManyToOne
    @JoinColumn(name = "\"TypeID\"", insertable = false, updatable = false)
    private Tipo tipo;

    @OneToMany(mappedBy = "torneo")
    private List<Inscripcion> inscripciones;

    public Torneo(String nombreTorneo, String tipoTorneo) {
        this.nombreTorneo = nombreTorneo;
        this.tipoTorneo = tipoTorneo;
    }


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