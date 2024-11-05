package co.edu.uniquindio.poo.controller;

import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;

public class ReservasController {
    
    Empresa empresa;

    public ReservasController(Empresa empresa){
        this.empresa = empresa;
    }

    public boolean crearReserva(Reserva reserva){
        return empresa.agregarReserva(reserva);
    }

    public Collection<Reserva> obtenerListaReservas(){
        return empresa.getReservas();
    }

    public boolean eliminarReserva(LocalDate fechaInicio){
        return empresa.eliminarReserva(fechaInicio);
    }

    public boolean actualizarReserva(LocalDate fechaInicio, Reserva reserva){
        return empresa.actualizarReserva(fechaInicio,reserva);
    }

}
