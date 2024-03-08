package org.example.modelo;
import jakarta.persistence.*;
@Entity
@Table(name = "Team")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TeamName")
    private String nombreEquipo;

    @Column(name = "PracticeNight")
    private String nochePractica;

    @Column(name = "Manager")
    private Integer manager;

    // Constructores, getters, setters y otros métodos pueden agregarse aquí

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNochePractica() {
        return nochePractica;
    }

    public void setNochePractica(String nochePractica) {
        this.nochePractica = nochePractica;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    // Ejemplo de constructor
    public Equipo(String nombreEquipo, String nochePractica, Integer manager) {
        this.nombreEquipo = nombreEquipo;
        this.nochePractica = nochePractica;
        this.manager = manager;
    }

    public Equipo() {
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", nochePractica='" + nochePractica + '\'' +
                ", manager=" + manager +
                '}';
    }
}