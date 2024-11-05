package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo implements IReserva{
    // Atributos
    private double capacidadCarga;
    private double precio;

    // Constructor
    public Camioneta(String matricula, String marca, String modelo, String anoFabricacion, double capacidadCarga) {
        super(matricula, marca, modelo, anoFabricacion);
        this.capacidadCarga = capacidadCarga;
        precio = calcularCostoReserva();
    }

    // Getters y Setters
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "TipoVehiculo: Camioneta, " + super.toString() ;
    }

    

    // Funciones
        // Definimos la funcion para calcular costo total de la reserva
        @Override
        public double calcularCostoReserva() {
            // Otra vez tenemos una tarifa base
            double costoTotal = 12000;

            // Por cada tonelada vamos agregar un 2% a la tarifa base
            costoTotal += 12000 * 0.2 * capacidadCarga;
            return costoTotal;
        }    
}
