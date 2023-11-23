package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoReserva;
import co.edu.uniquindio.proyectoFinal.interfaces.MENU;

import javax.swing.*;
import java.time.LocalDate;

public class MenuReserva  implements MENU {

    private Hotel hotel;

    public MenuReserva(){

    }

    public MenuReserva(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void mostrarMenu() {

        if (this.hotel == null) {
            JOptionPane.showMessageDialog(null, "No existe un hotel", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String menu = "a. Crear Reserva\n" +
                "b. Actualizar Reserva\n" +
                "c. Obtener Reserva\n" +
                "d. Listar Id Reservas\n" +
                "e. Eliminar Reserva\n" +
                "f. Volver" +
                "\n\nIngresa la opcion";

        char op;
        String opcion = "";
        do {

            opcion = JOptionPane.showInputDialog(menu);
            op = opcion.charAt(0);
            String idReserva = "";
            String fechaEntradaLectura = "";
            String fechaSalidaLectura = "";
            int numeroHuespedes = 0;
            String codigoHuesped = "";
            String codigoHabitacion = "";
            EstadoReserva estadoReserva = EstadoReserva.PENDIENTE;
            Reserva reserva;
            String mensaje = "";

            switch (op) {


                case 'a':
                    idReserva = JOptionPane.showInputDialog("ingrese el codigo de la reserva");
                    fechaEntradaLectura = JOptionPane.showInputDialog("ingrese la fecha de entrada. Debe estar en formato yyyy-MM-dd");
                    fechaSalidaLectura = JOptionPane.showInputDialog("ingrese la fecha de salida. Debe estar en formato yyyy-MM-dd");
                    numeroHuespedes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de huespedes"));
                    codigoHuesped = JOptionPane.showInputDialog("Ingrese el codigo del huesped");
                    codigoHabitacion = JOptionPane.showInputDialog("Ingrese el codigo de la habitacion");

                    LocalDate fechaEntrada = LocalDate.parse(fechaEntradaLectura);
                    LocalDate fechaSalida = LocalDate.parse(fechaSalidaLectura);

                    reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    reserva.setFechaEntrada(fechaEntrada);
                    reserva.setFechaSalida(fechaSalida);
                    reserva.setNumeroHuespedes(numeroHuespedes);
                    reserva.setCodigoHuesped(codigoHuesped);
                    reserva.setCodigoHabitacion(codigoHabitacion);

                    if (this.hotel.crearReserva(reserva))
                        JOptionPane.showMessageDialog(null, "Se creo la reserva satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 'b':

                    idReserva = JOptionPane.showInputDialog("ingrese el codigo de la reserva que desea modificar");
                    fechaEntradaLectura = JOptionPane.showInputDialog("ingrese la fecha de entrada. Debe estar en formato yyyy-MM-dd");
                    fechaSalidaLectura = JOptionPane.showInputDialog("ingrese la fecha de salida. Debe estar en formato yyyy-MM-dd");
                    numeroHuespedes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de huespedes"));

                    LocalDate fechaEntrada2 = LocalDate.parse(fechaEntradaLectura);
                    LocalDate fechaSalida2 = LocalDate.parse(fechaSalidaLectura);

                    reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    reserva.setFechaEntrada(fechaEntrada2);
                    reserva.setFechaSalida(fechaSalida2);
                    reserva.setNumeroHuespedes(numeroHuespedes);

                    if (this.hotel.actualizarReserva(idReserva,reserva))
                        JOptionPane.showMessageDialog(null, "Se actualizo la reserva satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'c':

                    idReserva = JOptionPane.showInputDialog("Ingrese el codigo de la reserva que desea observar");
                    reserva = this.hotel.obtenerReserva(idReserva);
                    if(reserva != null){
                        mensaje = "Cantidad Huespedes: " + reserva.getNumeroHuespedes() + "\n" +
                                "Fecha entrada " + reserva.getFechaEntrada() + "\n" +
                                "Fecha salida: " + reserva.getFechaSalida() + "\n" +
                                "Codigo de huesped " + reserva.getCodigoHuesped() +"\n" +
                                "Numero de habitacion: " + reserva.getCodigoHabitacion() + "\n" +
                                "Estado reserva" + reserva.getEstadoReserva() + "\n" +
                                "Tarifa :" + reserva.getTarifaReserva() + "\n";
                        JOptionPane.showMessageDialog(null, mensaje, "Reserva",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                    break;
                case 'd':

                    mensaje = this.hotel.listaIdReservas();
                    JOptionPane.showMessageDialog(null, mensaje, "Huespedes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'e':
                    idReserva = JOptionPane.showInputDialog("Ingrese el codigo de la reserva  que desea eliminar");
                    if(this.hotel.eliminarReserva(idReserva)){
                        JOptionPane.showMessageDialog(null, "Se eliminó la reserva correctamente", "Eliminación",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    break;
                case 'f':
                    JOptionPane.showMessageDialog(null, "Adios", "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Petición invalida", "Error",
                            JOptionPane.ERROR);

            }

        } while (op != 'f');
    }

}
