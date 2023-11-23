package co.edu.uniquindio.proyectoFinal.principal;

import co.edu.uniquindio.proyectoFinal.Clases.Huesped;
import co.edu.uniquindio.proyectoFinal.enumeraciones.*;
import co.edu.uniquindio.proyectoFinal.Clases.*;
import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoHabitacion;
import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoReserva;
import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoHabitacion;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = inicializador();
        MenuGeneral menuGeneral = new MenuGeneral(hotel);
        menuGeneral.mostrarMenu();
    }


    public static Hotel inicializador() {

        Hotel hotel = new Hotel();
        hotel.setNombre("Las bailarinas");

        Huesped huesped = new Huesped();
        huesped.setNombre("Felipe");
        huesped.setApellido("Perez");
        huesped.setNumeroIdentificacion("1234");
        huesped.setCorreo("mcdscsd@cdsd.com");
        huesped.setNumeroTelefono("300636");
        huesped.setTipoIdentificacion("Cedula");

        Habitacion habitacion = new Habitacion();
        habitacion.setCodigo("1234");
        habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
        habitacion.setTipoHabitacion(TipoHabitacion.ESTANDAR);
        habitacion.setCapacidadPersonas(5);
        habitacion.setPrecioNoche(50000);



        Reserva reserva = new Reserva();
        LocalDate fechaEntrada = LocalDate.parse("2023-11-18");
        LocalDate fechaSalida = LocalDate.parse("2023-11-22");
        reserva.setFechaEntrada(fechaEntrada);
        reserva.setFechaSalida(fechaSalida);
        reserva.setCodigoHabitacion("1234");
        reserva.setCodigoHuesped("1234");
        reserva.setNumeroHuespedes(4);
        reserva.setIdReserva("1");
        reserva.setTarifaReserva(800000);
        reserva.setEstadoReserva(EstadoReserva.PENDIENTE);

        hotel.crearHuesped(huesped);
        hotel.crearHabitacion(habitacion);
        hotel.crearReserva(reserva);


        return hotel;
    }
}