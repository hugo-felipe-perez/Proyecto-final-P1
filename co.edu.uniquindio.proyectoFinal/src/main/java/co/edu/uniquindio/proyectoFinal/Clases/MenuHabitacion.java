package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoHabitacion;
import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoHabitacion;
import co.edu.uniquindio.proyectoFinal.interfaces.MENU;

import javax.swing.*;

public class MenuHabitacion implements MENU {

    private Hotel hotel;

    public MenuHabitacion(){

    }
    public MenuHabitacion(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHote() {
        return hotel;
    }

    public void setHote(Hotel hote) {
        this.hotel = hote;
    }

    public void mostrarMenu() {

        if (this.hotel == null) {
            JOptionPane.showMessageDialog(null, "No existe un hotel", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String menu = "a. Crear Habitacion\n" +
                "b. Actualizar Habitacion\n" +
                "c. Obtener Habitacion\n" +
                "d. Listar Id Habitaciones\n" +
                "e. Eliminar Habitacion \n" +
                "f. Volver" +
                "\n\nIngresa la opcion";

        char op;
        String opcion = "";
        do {


            opcion = JOptionPane.showInputDialog(menu);
            op = opcion.charAt(0);
            String codigo = "";
            int capacidadPersonas = 0;
            double precioNoche = 0;
            String tipoHabitacionLectura = "";
            TipoHabitacion tipoHabitacion;
            EstadoHabitacion estadoHabitacion = EstadoHabitacion.DISPONIBLE;
            Habitacion habitacion;
            String mensaje = "";

            switch (op) {


                case 'a':
                    codigo = JOptionPane.showInputDialog("ingrese el codigo");
                    capacidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("ingrese la capacidad de personas"));
                    tipoHabitacionLectura = JOptionPane.showInputDialog("a.Estandar\nb.Swit\nc.Familiar");
                    if(tipoHabitacionLectura.charAt(0) == 'a')
                        tipoHabitacion = TipoHabitacion.ESTANDAR;
                    else if(tipoHabitacionLectura.charAt(0) == 'b')
                        tipoHabitacion = TipoHabitacion.SWIT;
                    else if(tipoHabitacionLectura.charAt(0) == 'c')
                        tipoHabitacion = TipoHabitacion.FAMILIAR;
                    else
                        tipoHabitacion = TipoHabitacion.ESTANDAR;
                    precioNoche = Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio por noche"));

                    habitacion = new Habitacion();
                    habitacion.setCodigo(codigo);
                    habitacion.setEstadoHabitacion(estadoHabitacion);
                    habitacion.setPrecioNoche(precioNoche);
                    habitacion.setCapacidadPersonas(capacidadPersonas);
                    habitacion.setTipoHabitacion(tipoHabitacion);


                    if (this.hotel.crearHabitacion(habitacion))
                        JOptionPane.showMessageDialog(null, "Se creo la habitacion satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 'b':

                    codigo = JOptionPane.showInputDialog("Ingrese el codigo de la habitacion que va a modificar");

                    capacidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("ingrese la capacidad de personas"));
                    tipoHabitacionLectura = JOptionPane.showInputDialog("a.Estandar\nb.Swit\nFamiliar");
                    if(tipoHabitacionLectura.charAt(0) == 'a')
                        tipoHabitacion = TipoHabitacion.ESTANDAR;
                    else if(tipoHabitacionLectura.charAt(0) == 'b')
                        tipoHabitacion = TipoHabitacion.SWIT;
                    else if(tipoHabitacionLectura.charAt(0) == 'c')
                        tipoHabitacion = TipoHabitacion.FAMILIAR;
                    else
                        tipoHabitacion = TipoHabitacion.ESTANDAR;
                    precioNoche = Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio por noche"));

                    habitacion = new Habitacion();
                    habitacion.setCodigo(codigo);
                    habitacion.setEstadoHabitacion(estadoHabitacion);
                    habitacion.setPrecioNoche(precioNoche);
                    habitacion.setCapacidadPersonas(capacidadPersonas);
                    habitacion.setTipoHabitacion(tipoHabitacion);

                    if (this.hotel.actualizarHabitacion(codigo,habitacion))
                        JOptionPane.showMessageDialog(null, "Se actualizo el huesped satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'c':

                    codigo = JOptionPane.showInputDialog("Ingrese el codigo de la habitacion que desea observar");
                    habitacion = this.hotel.obtenerHabitacion(codigo);
                    if(habitacion != null){
                        mensaje = "Tipo: " + habitacion.getTipoHabitacion() + "\n" +
                                "Precio: " + habitacion.getPrecioNoche() + "\n" +
                                "Capacidad: " + habitacion.getCapacidadPersonas() + "\n" +
                                "Estado: " + habitacion.getEstadoHabitacion() +"\n";
                        JOptionPane.showMessageDialog(null, mensaje, "Habitacion",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                    break;
                case 'd':

                    mensaje = this.hotel.listaIdHabitaciones();
                    JOptionPane.showMessageDialog(null, mensaje, "Habitaciones",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'e':
                    codigo = JOptionPane.showInputDialog("Ingrese el codigo de la habitacion  desea eliminar");
                    if(this.hotel.eliminarHabitacion(codigo)){
                        JOptionPane.showMessageDialog(null, "Se eliminó la habitacion correctamente", "Eliminación",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                case 'f':

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Petición invalida", "Error",
                            JOptionPane.ERROR);

            }

        } while (op != 'f');
    }
}
