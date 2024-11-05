package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo implements IReserva{
    // Atributos
    private TipoCaja tipoCaja;
    private double precio;

    // Constructor
    public Moto(String matricula, String marca, String modelo, String anoFabricacion, TipoCaja tipoCaja) {
        super(matricula, marca, modelo, anoFabricacion);
        this.tipoCaja = tipoCaja;
        precio = calcularCostoReserva();
    }

    // Getters y Setters
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }
    

    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "TipoVehiculo: Moto, " + super.toString() ;
    }

    // Funciones
        // Definimos la función para calcular costo de la reserva
        @Override
        public double calcularCostoReserva() {
            // Esta sera la tarifa base(12.000)
            double costoTotal = 12000;
            // Agregamos la tarifa adicional en caso de ser Automatica
            if (tipoCaja == TipoCaja.AUTOMATICO){
                costoTotal+=10000;
            }
            return costoTotal;
        }
}
