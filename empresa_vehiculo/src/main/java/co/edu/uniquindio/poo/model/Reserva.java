package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    // Atributos
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int diasReserva;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private double precio;


    // Constructor
    public Reserva(LocalDate fechaInicial, LocalDate fechaFinal, Vehiculo vehiculo, Cliente cliente) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.diasReserva = calcularDias();
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.precio = 0;

        // Verificar si el vehículo implementa IReserva
         if (vehiculo instanceof Auto) {
            Auto auto = (Auto) vehiculo;
            this.precio = auto.calcularCostoReserva() * diasReserva;
        } else if (vehiculo instanceof IReserva) {
            // Calcular precio sin multiplicar por los días para los otros vehículos
            this.precio = ((IReserva) vehiculo).calcularCostoReserva();
        } 
    }

    // Getters y Setters
    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(int diasReserva) {
        this.diasReserva = diasReserva;
    }

    // Funciones
        // Esta función calcula en dias, el tiempo entre dos fechas (Hacemos la conversion a int)
        public int calcularDias(){
            int numeroDias = (int) ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
            return numeroDias;
        }
        
}
