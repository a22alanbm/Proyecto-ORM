package org.example.modelo;

public class Inscripcion {
    // Representa la tabla 'Entry' en la base de datos
    private int idMiembro;  // Corresponde al atributo 'MemberID' en la tabla
    private int idTorneo;   // Corresponde al atributo 'TourID' en la tabla
    private int año;        // Corresponde al atributo 'Year' en la tabla

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
}