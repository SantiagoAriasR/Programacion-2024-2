package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;


public class Empresa {
    // Atributos
    private String nombre;
    private Collection<Reserva> reservas;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        reservas = new LinkedList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Funciones
        // Funcion para agregar Reserva
        public boolean agregarReserva(Reserva reserva){
            boolean centinela = false;
            if (!verificarReserva(reserva.getFechaInicial())){
                reservas.add(reserva);
                centinela = true;
            }
            return centinela;
        }

        // Funcion eliminar Reserva
        public boolean eliminarReserva(LocalDate fechaInicial){
            boolean centinela = false;
            for (Reserva reserva : reservas){
                if (reserva.getFechaInicial().equals(fechaInicial)){
                    reservas.remove(reserva);
                    centinela = true;
                    break;
                }
            }
            return centinela;
        }

        // Funcion para actualizar Reserva
        public boolean actualizarReserva(LocalDate fechaInicial, Reserva actualizado){
            boolean centinela = false;
            for (Reserva reserva : reservas){
                if (reserva.getFechaInicial().equals(fechaInicial)){
                    reserva.setFechaInicial(actualizado.getFechaInicial());
                    reserva.setFechaFinal(actualizado.getFechaFinal());
                    reserva.setCliente(actualizado.getCliente());
                    reserva.setVehiculo(actualizado.getVehiculo());
                    reserva.setDiasReserva(actualizado.getDiasReserva());
                    reserva.setPrecio(actualizado.getPrecio());
                    centinela = true;
                    break;
                }
            }
            return centinela;
        }
        
        // Funcion para verificar Reserva
        public boolean verificarReserva(LocalDate fechaInicial){
            boolean centinela = false;
            for (Reserva reserva : reservas){
                if (reserva.getFechaInicial().equals(fechaInicial)){
                    centinela = true;
                }
            }
            return centinela;
        }
}
