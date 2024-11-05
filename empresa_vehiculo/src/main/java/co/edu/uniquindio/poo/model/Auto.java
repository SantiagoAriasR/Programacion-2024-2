package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo implements IReserva{
    // Atributos 
    private int numeroPuertas;
    private double precio;


    // Constructor
    public Auto(String matricula, String marca, String modelo, String anoFabricacion, int numeroPuertas) {
        super(matricula, marca, modelo, anoFabricacion);
        this.numeroPuertas = numeroPuertas;
        precio = calcularCostoReserva();
    }

    // Getters y Setters
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodo toString
        @Override
    public String toString() {
        return "TipoVehiculo: Auto, " + super.toString() ;
    }

        // Funciones
        // Definimos la funcion para calcular el costo de la Reserva
        @Override
        public double calcularCostoReserva() {
            // Calculamos la reserva para Auto (12.000 tarifa base)
            double totalReserva = 12000;
            return totalReserva;
        }

    
    
    
}
