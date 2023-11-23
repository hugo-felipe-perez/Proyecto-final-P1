package co.edu.uniquindio.proyectoFinal.Clases;


import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoFactura;
import co.edu.uniquindio.proyectoFinal.interfaces.MENU;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuOperaciones implements MENU {

    private Hotel hotel;

    public MenuOperaciones() {

    }

    public MenuOperaciones(Hotel hotel) {
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

        String menu = "a. Confirmar Reserva\n" +
                "b. Cancelar Reserva\n" +
                "c. dar Reserva por terminada\n" +
                "d. Listar facturas dado un cliente\n" +
                "e. Volver" +
                "\n\nIngresa la opcion";

        char op;
        String opcion = "";
        do {

            opcion = JOptionPane.showInputDialog(menu);
            op = opcion.charAt(0);
            String id = "";
            String idRerva = "";
            String pais = "";
            String ciudad = "";
            String departamento = "";
            String codigoPostal = "";
            String mensaje = "";
            TipoFactura tipoFactura = TipoFactura.CHECKIN;
            switch (op) {

                case 'a':

                    JOptionPane.showMessageDialog(null, "Se creara una factura check In, al continuación se le pediran unos datos.", "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);

                    idRerva = JOptionPane.showInputDialog("ingrese el codigo de la reserva");
                    id = JOptionPane.showInputDialog("ingrese el codigo de la nueva factura");
                    ciudad = JOptionPane.showInputDialog("Ingrese la ciudad");
                    departamento = JOptionPane.showInputDialog("Ingrese el departamento");
                    pais = JOptionPane.showInputDialog("Ingrese el pais");
                    codigoPostal = JOptionPane.showInputDialog("Ingrese el codigo postal");

                    Factura factura = new Factura();
                    factura.setId(id);
                    factura.setCity(ciudad);
                    factura.setDepartamento(departamento);
                    factura.setPostalCode(codigoPostal);
                    factura.setPais(pais);
                    factura.setTipo(tipoFactura);

                    if (this.hotel.confirmarReserva(factura, idRerva))
                        JOptionPane.showMessageDialog(null, "Se creo la reserva satisfactoriamente.", "Informacion",
                                JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'b':
                    idRerva = JOptionPane.showInputDialog("ingrese el codigo de la reserva");
                    if (this.hotel.cancelarReserva(idRerva))
                        JOptionPane.showMessageDialog(null, "Se cancelo la reserva satisfactoriamente.", "Informacion",
                                JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 'c':

                    idRerva = JOptionPane.showInputDialog("ingrese el codigo de la reserva");

                    ArrayList<Servicio> listaServicios = new ArrayList<>();
                    String subOpcion = JOptionPane.showInputDialog("se consumieron servicios ? (presione s para si y n para no. si presione algo diferente se asumuara que no)");
                    char subOp = subOpcion.charAt(0);

                    if (subOp == 's') {
                        String subSubOpcion = "";
                        char subSubOp = ' ';
                        String masServicios = "";
                        char masServ = ' ';

                        do {

                            subSubOpcion = JOptionPane.showInputDialog("Que servicio consumio?\n" +
                                    "a. Comida : 80000\n" +
                                    "b. aire acondicionado: 50000\n" +
                                    "c. jacuzzi: 60000 ");
                            subSubOp = subSubOpcion.charAt(0);
                            Servicio servicio = new Servicio();
                            if (subSubOp == 'a') {
                                servicio.setNombre("Comida");
                                servicio.setPrecio(80000);
                            } else if (subSubOp == 'b') {
                                servicio.setNombre("Aire acondicionado");
                                servicio.setPrecio(50000);
                            } else if (subSubOp == 'c') {
                                servicio.setNombre("Jacuzzi");
                                servicio.setPrecio(60000);
                            }
                            listaServicios.add(servicio);

                            masServicios = JOptionPane.showInputDialog("Desea agregar otro ?");
                            masServ = masServicios.charAt(0);
                        } while (masServ != 'n');

                        id = JOptionPane.showInputDialog("ingrese el codigo de la nueva factura");
                        ciudad = JOptionPane.showInputDialog("Ingrese la ciudad");
                        departamento = JOptionPane.showInputDialog("Ingrese el departamento");
                        pais = JOptionPane.showInputDialog("Ingrese el pais");
                        codigoPostal = JOptionPane.showInputDialog("Ingrese el codigo postal");

                        Factura factura2 = new Factura();
                        factura2.setId(id);
                        factura2.setCity(ciudad);
                        factura2.setDepartamento(departamento);
                        factura2.setPostalCode(codigoPostal);
                        factura2.setPais(pais);
                        factura2.setTipo(TipoFactura.CHECKOUT);
                        if(this.hotel.agregarFacturaSalida(factura2, idRerva, listaServicios)){
                            JOptionPane.showMessageDialog(null, "Se agrego la factura correctamente", "Informacion",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        if (this.hotel.terminarReserva(idRerva))
                            JOptionPane.showMessageDialog(null, "No se genero factura de check out", "Informacion",
                                    JOptionPane.INFORMATION_MESSAGE);

                    }

                    break;
                case 'd' :

                    String idCliente = JOptionPane.showInputDialog("Ingrese el codigo del huesped");
                    mensaje = this.hotel.listarFacturas(idCliente);
                    JOptionPane.showMessageDialog(null, mensaje, "Huespedes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } while (op != 'e');
    }
}
