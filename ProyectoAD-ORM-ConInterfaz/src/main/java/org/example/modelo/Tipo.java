package org.example.modelo;

public class Tipo {
    // Representa la tabla 'Type' en la base de datos
    private String tipo;   // Corresponde al atributo 'Type' en la tabla
    private int tarifa;     // Corresponde al atributo 'Fee' en la tabla

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