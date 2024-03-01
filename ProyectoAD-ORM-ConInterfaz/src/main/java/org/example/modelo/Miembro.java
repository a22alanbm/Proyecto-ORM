package org.example.modelo;


import java.util.Date;

public class Miembro {
    // Representa la tabla 'Member' en la base de datos
    private int idMiembro;          // Corresponde al atributo 'MemberID' en la tabla
    private String apellido;        // Corresponde al atributo 'LastName' en la tabla
    private String nombre;          // Corresponde al atributo 'FirstName' en la tabla
    private String tipoMiembro;     // Corresponde al atributo 'MemberType' en la tabla
    private String telefono;        // Corresponde al atributo 'Phone' en la tabla
    private Integer handicap;        // Corresponde al atributo 'Handicap' en la tabla
    private Date fechaIngreso;      // Corresponde al atributo 'JoinDate' en la tabla
    private Integer coach;           // Corresponde al atributo 'Coach' en la tabla (MemberID)
    private String equipo;          // Corresponde al atributo 'Team' en la tabla
    private String genero;          // Corresponde al atributo 'Gender' en la tabla

    // Constructores, getters, setters y otros métodos pueden agregarse aquí

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(String tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
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

    public Integer getCoach() {
        return coach;
    }

    public void setCoach(Integer coach) {
        this.coach = coach;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Ejemplo de constructor
    public Miembro(int idMiembro, String apellido, String nombre, String tipoMiembro, String telefono,
                   Integer handicap, Date fechaIngreso, Integer coach, String equipo, String genero) {
        this.idMiembro = idMiembro;
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoMiembro = tipoMiembro;
        this.telefono = telefono;
        this.handicap = handicap;
        this.fechaIngreso = fechaIngreso;
        this.coach = coach;
        this.equipo = equipo;
        this.genero = genero;
    }

    public Miembro() {
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "idMiembro=" + idMiembro +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoMiembro='" + tipoMiembro + '\'' +
                ", telefono='" + telefono + '\'' +
                ", handicap=" + handicap +
                ", fechaIngreso=" + fechaIngreso +
                ", coach=" + coach +
                ", equipo='" + equipo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}