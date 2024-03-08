package org.example.modelo;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Member")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MemberID")
    private int idMiembro;

    @Column(name = "LastName")
    private String apellido;

    @Column(name = "FirstName")
    private String nombre;

    @Column(name = "MemberType")
    private String tipoMiembro;

    @Column(name = "Phone")
    private String telefono;

    @Column(name = "Handicap")
    private Integer handicap;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Column(name = "Coach")
    private Integer coach;

    @Column(name = "Team")
    private String equipo;

    @Column(name = "Gender")
    private String genero;
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