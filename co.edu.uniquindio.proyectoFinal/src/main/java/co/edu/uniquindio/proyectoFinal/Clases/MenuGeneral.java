package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.interfaces.MENU;

import javax.swing.*;

public class MenuGeneral implements MENU {

    private Hotel hotel = null;

    private MenuHabitacion menuHabitacion = null;
    private MenuHuesped menuHuesped = null;

    private MenuReserva menuReserva = null;

    private MenuOperaciones menuOperaciones = null;

    public MenuGeneral() {

    }

    public MenuGeneral(Hotel hotel) {
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

        String menu = "a. Operaciones Crud Huesped\n" +
                "b. Operaciones Crud Habitación\n" +
                "c. Operaciones Crud Reserva\n" +
                "d. Operaciones con reservas\n" +
                "e. Salir\n\n" +
                "Ingresa la opción";

        char op;
        do {
            String opcion = JOptionPane.showInputDialog(menu);
            op = opcion.charAt(0);

            switch (op) {

                case 'a':
                    this.menuHuesped = new MenuHuesped(this.hotel);
                    this.menuHuesped.mostrarMenu();
                    break;
                case 'b':
                    this.menuHabitacion = new MenuHabitacion(this.hotel);
                    this.menuHabitacion.mostrarMenu();
                    break;
                case 'c':
                    this.menuReserva = new MenuReserva(this.hotel);
                    this.menuReserva.mostrarMenu();
                    break;
                case 'd':
                    this.menuOperaciones = new MenuOperaciones(this.hotel);
                    this.menuOperaciones.mostrarMenu();
                    break;
                case 'e':
                    JOptionPane.showMessageDialog(null, "Adios", "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Petición invalida", "Error",
                            JOptionPane.ERROR);

            }

        } while (op != 'e');
    }


}
