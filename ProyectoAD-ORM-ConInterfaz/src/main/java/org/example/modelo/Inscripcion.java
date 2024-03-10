package org.example.modelo;
import jakarta.persistence.*;
@Entity
@Table(name = "\"Entry\"")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"EntryID\"")
    private int idInscripcion;

    @Column(name = "\"MemberID\"")
    private int idMiembro;

    @Column(name = "\"TourID\"")
    private int idTorneo;

    @Column(name = "\"EYear\"")
    private int año;
    // Constructores, getters, setters y otros métodos pueden agregarse aquí

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

    // Ejemplo de constructor
    public Inscripcion(int idMiembro, int idTorneo, int año) {
        this.idMiembro = idMiembro;
        this.idTorneo = idTorneo;
        this.año = año;
    }

    public Inscripcion() {
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idMiembro=" + idMiembro +
                ", idTorneo=" + idTorneo +
                ", año=" + año +
                '}';
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }
}