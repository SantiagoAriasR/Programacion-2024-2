package co.edu.uniquindio.poo.model;

public class Cliente {
    // Atributos
    private String nombre;
    private String cedula;
    
    // Constructor
    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cedula: " + cedula;
    }

    

    
    
}
