package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.interfaces.MENU;

import javax.swing.*;

public class MenuHuesped implements MENU  {

    private Hotel hotel;

    public MenuHuesped() {

    }

    public MenuHuesped(Hotel hotel) {
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

        String menu = "a. Crear Husped\n" +
                "b. Actualizar Huespeds\n" +
                "c. Obtener Huesped\n" +
                "d. Listar Id Huespedes\n" +
                "e. Eliminar Huesped \n" +
                "f. Volver" +
                "\n\nIngresa la opcion";

        char op;
        String opcion = "";
        do {


            opcion = JOptionPane.showInputDialog(menu);
            op = opcion.charAt(0);
            String nombre = "";
            String apellido = "";
            String numeroIdentificacion = "";
            String tipoIdentificacion = "";
            String numeroTelefono = "";
            String correo = "";
            Huesped huesped;
            String mensaje = "";

            switch (op) {


                case 'a':
                    nombre = JOptionPane.showInputDialog("ingrese el nombre");
                    apellido = JOptionPane.showInputDialog("ingrese el apellido");
                    numeroIdentificacion = JOptionPane.showInputDialog("Ingrese el numero de identificacion");
                    tipoIdentificacion = JOptionPane.showInputDialog("Ingrese el tipo de identificacion");
                    numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono");
                    correo = JOptionPane.showInputDialog("Ingrese el correo electronico");

                    huesped = new Huesped();
                    huesped.setNombre(nombre);
                    huesped.setApellido(apellido);
                    huesped.setCorreo(correo);
                    huesped.setNumeroTelefono(numeroTelefono);
                    huesped.setTipoIdentificacion(tipoIdentificacion);
                    huesped.setNumeroIdentificacion(numeroIdentificacion);


                    if (this.hotel.crearHuesped(huesped))
                        JOptionPane.showMessageDialog(null, "Se creo el huesped satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 'b':

                    numeroIdentificacion = JOptionPane.showInputDialog("Ingrese el numero de identificación de la persona que va a modificar");

                    nombre = JOptionPane.showInputDialog("ingrese el nombre");
                    apellido = JOptionPane.showInputDialog("ingrese el apellido");
                    tipoIdentificacion = JOptionPane.showInputDialog("Ingrese el tipo de identificacion");
                    numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono");
                    correo = JOptionPane.showInputDialog("Ingrese el correo electronico");

                    huesped = new Huesped();
                    huesped.setNombre(nombre);
                    huesped.setApellido(apellido);
                    huesped.setCorreo(correo);
                    huesped.setNumeroTelefono(numeroTelefono);
                    huesped.setTipoIdentificacion(tipoIdentificacion);
                    huesped.setNumeroIdentificacion(numeroIdentificacion);

                    if (this.hotel.actualizarHuesped(numeroIdentificacion,huesped))
                        JOptionPane.showMessageDialog(null, "Se actualizo el huesped satisfactoriamente", "Ok",
                                JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 'c':

                    numeroIdentificacion = JOptionPane.showInputDialog("Ingrese el numero de identificación de la persona que desea observar");
                    huesped = this.hotel.obtenerHuesped(numeroIdentificacion);
                    if(huesped != null){
                        mensaje = "Nombre: " + huesped.getNombre() + "\n" +
                                "Apellido: " + huesped.getApellido() + "\n" +
                                "Correo: " + huesped.getCorreo() + "\n" +
                                "Tipo de identificación: " + huesped.getTipoIdentificacion() +"\n" +
                                "Numero de telefono: " + huesped.getNumeroTelefono() + "\n";
                        JOptionPane.showMessageDialog(null, mensaje, "Huesped",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                    break;
                case 'd':

                    mensaje = this.hotel.listaIdClientes();
                    JOptionPane.showMessageDialog(null, mensaje, "Huespedes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'e':
                    numeroIdentificacion = JOptionPane.showInputDialog("Ingrese el numero de identificación de la persona que desea eliminar");
                    if(this.hotel.eliminarHuesped(numeroIdentificacion)){
                        JOptionPane.showMessageDialog(null, "Se eliminó el cliente correctamente", "Eliminación",
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
