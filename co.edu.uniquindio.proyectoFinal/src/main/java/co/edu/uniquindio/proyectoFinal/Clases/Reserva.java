package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoReserva;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {

    private  String idReserva;

    private LocalDate fechaEntrada;

    private LocalDate fechaSalida;

    private int numeroHuespedes;

    private double tarifaReserva;

    private String codigoHuesped;

    private String codigoHabitacion;

    private EstadoReserva estadoReserva;

    public Reserva(){

    }
    public Reserva(String idReserva, LocalDate fechaEntrada, LocalDate fechaSalida, int numeroHuespedes, double tarifaReserva, String codigoHuesped, String codigoHabitacion, EstadoReserva estadoReserva) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.tarifaReserva = tarifaReserva;
        this.codigoHuesped = codigoHuesped;
        this.codigoHabitacion = codigoHabitacion;
        this.estadoReserva = estadoReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(int numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    public double getTarifaReserva() {
        return tarifaReserva;
    }

    public void setTarifaReserva(double tarifaReserva) {
        this.tarifaReserva = tarifaReserva;
    }

    public String getCodigoHuesped() {
        return codigoHuesped;
    }

    public void setCodigoHuesped(String codigoHuesped) {
        this.codigoHuesped = codigoHuesped;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", numeroHuespedes=" + numeroHuespedes +
                ", tarifaReserva=" + tarifaReserva +
                ", codigoHuesped='" + codigoHuesped + '\'' +
                ", codigoHabitacion='" + codigoHabitacion + '\'' +
                ", estadoReserva=" + estadoReserva +
                '}';
    }
}
