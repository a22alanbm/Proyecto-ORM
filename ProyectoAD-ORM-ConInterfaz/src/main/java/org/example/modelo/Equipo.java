package org.example.modelo;

public class Equipo {
    // Representa la tabla 'Team' en la base de datos
    private String nombreEquipo;    // Corresponde al atributo 'TeamName' en la tabla
    private String nochePractica;    // Corresponde al atributo 'PracticeNight' en la tabla
    private Integer manager;         // Corresponde al atributo 'Manager' en la tabla (MemberID)

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