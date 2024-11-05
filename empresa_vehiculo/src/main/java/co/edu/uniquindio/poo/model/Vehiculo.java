package co.edu.uniquindio.poo.model;

public class Vehiculo {
    // Atributos
    public String matricula;
    public String marca;
    public String modelo;
    public String anoFabricacion;
    public String precio;
    
    // Constructor
    public Vehiculo(String matricula, String marca, String modelo, String anoFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(String anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Marca: " + marca;
    }       
}
