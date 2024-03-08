package org.example.modelo;
import jakarta.persistence.*;
@Entity
@Table(name = "Type")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Type")
    private String tipo;

    @Column(name = "Fee")
    private int tarifa;
    // Constructores, getters, setters y otros métodos pueden agregarse aquí

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

    // Ejemplo de constructor
    public Tipo(String tipo, int tarifa) {
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public Tipo() {
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "tipo='" + tipo + '\'' +
                ", tarifa=" + tarifa +
                '}';
    }
}