package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoHabitacion;
import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoReserva;
import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoFactura;

import javax.swing.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Hotel {

    private String nombre;
    private String direccion;

    private String totalHabitaciones;

    private String habitacionesDisponibles;

    private String horarioDeAtencion;

    private ArrayList<Huesped> listaHuespedes = new ArrayList<Huesped>();

    private ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

    private ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();

    private ArrayList<Factura> listaFacturas = new ArrayList<>();

    private ArrayList<DetalleFactura> listaDetallesFactura = new ArrayList<>();

    private ArrayList<Servicio> listaServicios = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String nombre, String direccion, String totalHabitaciones, String habitacionesDisponibles, String horarioDeAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.totalHabitaciones = totalHabitaciones;
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.horarioDeAtencion = horarioDeAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public void setTotalHabitaciones(String totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public String getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(String habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public String getHorarioDeAtencion() {
        return horarioDeAtencion;
    }

    public void setHorarioDeAtencion(String horarioDeAtencion) {
        this.horarioDeAtencion = horarioDeAtencion;
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public boolean crearHuesped(Huesped huesped) {

        if (this.obtenerHuesped(huesped.getNumeroIdentificacion()) != null) {
            JOptionPane.showMessageDialog(null, "el huesped ya existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.listaHuespedes.add(huesped);
        return true;
    }

    public Huesped obtenerHuesped(String documento) {
        Huesped huesped = null;

        for (int i = 0; i < listaHuespedes.size(); i++) {
            Huesped huespedBuscar = listaHuespedes.get(i);

                if (huespedBuscar.getNumeroIdentificacion().equalsIgnoreCase(documento)) {
                    huesped = huespedBuscar;
                    break;
                }
        }
        return huesped; // huesped no encontrada
    }

    public boolean actualizarHuesped(String numero, Huesped huespedActualizar) {

        boolean encontrado = false;
        if (this.obtenerHuesped(numero) == null) {
            JOptionPane.showMessageDialog(null, "el huesped no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < this.listaHuespedes.size(); i++) {
            Huesped huespedBuscar = listaHuespedes.get(i);
            if (huespedBuscar.getNumeroIdentificacion().equalsIgnoreCase(numero)) {
                this.listaHuespedes.set(i, huespedActualizar);
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public boolean eliminarHuesped(String numero) {

        boolean encontrado = false;
        if (this.obtenerHuesped(numero) == null) {
            JOptionPane.showMessageDialog(null, "el huesped no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        if (this.revisarHuespedReserva(numero)) {
            JOptionPane.showMessageDialog(null, "el huesped esta en una reserva activa. Por lo tanto no puede ser eliminado", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < listaHuespedes.size(); i++) {
            Huesped huesped = listaHuespedes.get(i);
            // Verificar si el huésped actual tiene el número de identificación buscado
            if (huesped.getNumeroIdentificacion().equalsIgnoreCase(numero)) {
                listaHuespedes.remove(i); // Eliminar el huésped de la lista
                encontrado = true;
                break; // Salir del bucle una vez que se ha encontrado y eliminado el huésped
            }
        }
        return encontrado;
    }

    public String listaIdClientes() {

        String mensaje = "";

        for (int i = 0; i < this.listaHuespedes.size(); i++) {
            mensaje += ("ID: " + listaHuespedes.get(i).getNumeroIdentificacion() + "\n");

        }
        if (mensaje.length() < 1)
            mensaje = "No hay huespedes";
        return mensaje;
    }

    public boolean crearHabitacion(Habitacion habitacion) {

        if (this.obtenerHabitacion(habitacion.getCodigo()) != null) {
            JOptionPane.showMessageDialog(null, "La habitación ya existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.listaHabitaciones.add(habitacion);
        return true;
    }

    public Habitacion obtenerHabitacion(String numero) {
        Habitacion habitacion = null;

        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitacion habitacionBuscar = listaHabitaciones.get(i);
            if (habitacionBuscar.getCodigo().equalsIgnoreCase(numero)) {
                habitacion = habitacionBuscar;
                break;
            }
        }
        return habitacion; // Habitacion no encontrada
    }

    public boolean actualizarHabitacion(String numero, Habitacion habitacionActualizar) {

        boolean encontrado = false;
        if (this.obtenerHabitacion(numero) == null) {
            JOptionPane.showMessageDialog(null, "La habitación no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < this.listaHabitaciones.size(); i++) {
            Habitacion habitacionBuscar = listaHabitaciones.get(i);
            if (habitacionBuscar.getCodigo().equalsIgnoreCase(numero)) {
                this.listaHabitaciones.set(i, habitacionActualizar);
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public boolean eliminarHabitacion(String numero) {

        boolean encontrado = false;
        if (this.obtenerHabitacion(numero) == null) {
            JOptionPane.showMessageDialog(null, "La habitación no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        if (this.revisarHabitacionReserva(numero)) {
            JOptionPane.showMessageDialog(null, "La habitación esta en una reserva activa. Por lo tanto no puede ser eliminada", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitacion habitacion = listaHabitaciones.get(i);
            // Verificar si la habitación actual tiene el número buscado
            if (habitacion.getCodigo().equalsIgnoreCase(numero)) {
                listaHabitaciones.remove(i); // Eliminar la habitación de la lista
                encontrado = true;
                break; // Salir del bucle una vez que se ha encontrado y eliminado la habitación
            }
        }
        return encontrado;
    }

    public String listaIdHabitaciones() {

        String mensaje = "";

        for (int i = 0; i < this.listaHabitaciones.size(); i++) {
            mensaje += ("ID: " + listaHabitaciones.get(i).getCodigo() + "\n");
        }
        if (mensaje.length() < 1)
            mensaje = "No hay habitaciones";
        return mensaje;
    }



    public void cambiarEstadoHabitacion(String numero,EstadoHabitacion estadoHabitacion){
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitacion habitacionBuscar = listaHabitaciones.get(i);
            if (habitacionBuscar.getCodigo().equalsIgnoreCase(numero)) {
                habitacionBuscar.setEstadoHabitacion(estadoHabitacion);
                break;
            }
        }
    }


    public boolean revisarHuespedReserva(String codigo) {

        boolean encontrado = false;
        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reservaBuscar = listaReservas.get(i);
            if (reservaBuscar.getCodigoHuesped().equalsIgnoreCase(codigo) && (reservaBuscar.getEstadoReserva() == EstadoReserva.CONFIRMADA || reservaBuscar.getEstadoReserva() == EstadoReserva.PENDIENTE)) {
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }

    public boolean revisarHabitacionReserva(String codigo) {

        boolean encontrado = false;
        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reservaBuscar = listaReservas.get(i);
            if (reservaBuscar.getCodigoHabitacion().equalsIgnoreCase(codigo) && (reservaBuscar.getEstadoReserva() == EstadoReserva.CONFIRMADA || reservaBuscar.getEstadoReserva() == EstadoReserva.PENDIENTE)) {
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }

    //Revisar Estado habitación
    public boolean revisarHabitacion(String codigo) {

        boolean esta = false;

        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitacion habitacionBuscar = listaHabitaciones.get(i);
            if (habitacionBuscar.getCodigo().equalsIgnoreCase(codigo) && (habitacionBuscar.getEstadoHabitacion() != EstadoHabitacion.DISPONIBLE)) {
                esta = true;
                break;
            }
        }

        return esta;
    }

    public boolean crearReserva(Reserva reserva) {

        //Se verifica que no haya una reserva igual.
        if (this.obtenerReserva(reserva.getIdReserva()) != null) {
            JOptionPane.showMessageDialog(null, "Una reserva con este codigo ya existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.obtenerHuesped(reserva.getCodigoHuesped()) == null) {
            JOptionPane.showMessageDialog(null, "Este huesped no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se verifica que el cliente no este en una reserva activa
        if (this.revisarHuespedReserva(reserva.getCodigoHuesped())) {
            JOptionPane.showMessageDialog(null, "Este huesped ya tiene una reserva activa", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se verifica que la habitación exista.
        if (this.obtenerHabitacion(reserva.getCodigoHabitacion()) == null) {
            JOptionPane.showMessageDialog(null, "Esta habitación no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.obtenerHabitacion(reserva.getCodigoHabitacion()).getCapacidadPersonas() < reserva.getNumeroHuespedes()){
            JOptionPane.showMessageDialog(null, "Esta habitación solo tiene capacidad para " + this.obtenerHabitacion(reserva.getCodigoHabitacion()).getCapacidadPersonas() + " y tu pusiste " + reserva.getNumeroHuespedes() , "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se verifica que la habitación no este en una reserva activa
        if (this.revisarHabitacionReserva(reserva.getCodigoHabitacion())) {
            JOptionPane.showMessageDialog(null, "Este huesped ya tiene una reserva activa", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se verifica que la habitacion este disponible
        if (this.revisarHabitacion(reserva.getCodigoHabitacion())) {
            JOptionPane.showMessageDialog(null, "Esta habitación no se encuentra disponible", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se trae la habitacion para saber el precio y asi calcular la tarifa
        double precioNoche = this.obtenerHabitacion(reserva.getCodigoHabitacion()).getPrecioNoche();
        long diferenciaDias = ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida());
        //Para calcular la reserva se multiplica el precio de noche de la habitacion por la diferencia de dias
        //y se le suma la multiplicacion del precio de nochde por la cantidad de huespedes
        reserva.setTarifaReserva(((precioNoche * diferenciaDias)  * reserva.getNumeroHuespedes()));

        //Se pone la habitacion como ocupada
        this.cambiarEstadoHabitacion(reserva.getCodigoHabitacion(),EstadoHabitacion.OCUPADO);
        this.listaReservas.add(reserva);
        return true;
    }

    // Método para obtener una reserva por su identificador
    public Reserva obtenerReserva(String id) {
        Reserva reserva = null;

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reservaBuscar = listaReservas.get(i);
            if (reservaBuscar.getIdReserva().equalsIgnoreCase(id)) {
                reserva = reservaBuscar;
                break;
            }
        }
        return reserva; // Reserva no encontrada
    }

    // Método para actualizar una reserva
    public boolean actualizarReserva(String id, Reserva reservaActualizar) {
        boolean encontrado = false;
        if (this.obtenerReserva(id) == null) {
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < this.listaReservas.size(); i++) {
            Reserva reservaBuscar = listaReservas.get(i);
            if (reservaBuscar.getIdReserva().equalsIgnoreCase(id)) {
                reservaActualizar.setCodigoHuesped(reservaBuscar.getCodigoHuesped());
                reservaActualizar.setCodigoHabitacion(reservaBuscar.getCodigoHabitacion());
                reservaActualizar.setEstadoReserva(reservaBuscar.getEstadoReserva());

                double precioNoche = this.obtenerHabitacion(reservaBuscar.getCodigoHabitacion()).getPrecioNoche();
                long diferenciaDias = ChronoUnit.DAYS.between(reservaActualizar.getFechaEntrada(), reservaActualizar.getFechaSalida());
                //Para calcular la reserva se multiplica el precio de noche de la habitacion por la diferencia de dias
                //y se le suma la multiplicacion del precio de nochde por la cantidad de huespedes
                reservaActualizar.setTarifaReserva(((precioNoche * diferenciaDias)  * reservaActualizar.getNumeroHuespedes()));


                this.listaReservas.set(i, reservaActualizar);
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    // Método para eliminar una reserva por su identificador
    // Método para eliminar una reserva por su identificador
    public boolean eliminarReserva(String id) {
        boolean encontrado = false;
        if (this.obtenerReserva(id) == null) {
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return encontrado;
        }

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            // Verificar si la reserva actual tiene el ID buscado
            if (reserva.getIdReserva().equalsIgnoreCase(id)) {
                this.cambiarEstadoHabitacion(reserva.getCodigoHabitacion(),EstadoHabitacion.DISPONIBLE);
                listaReservas.remove(i); // Eliminar la reserva de la lista

                encontrado = true;
                break; // Salir del bucle una vez que se ha encontrado y eliminado la reserva
            }
        }
        return encontrado;
    }

    public String listaIdReservas() {

        String mensaje = "";

        for (int i = 0; i < this.listaReservas.size(); i++) {
            mensaje += ("ID: " + listaReservas.get(i).getIdReserva() + "\n");
        }
        if (mensaje.length() < 1)
            mensaje = "No hay reservas";
        return mensaje;
    }

    public void cambiarEstadoReserva(String id, EstadoReserva estadoReserva){

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reservaBuscar = listaReservas.get(i);
            if (reservaBuscar.getIdReserva().equalsIgnoreCase(id)) {
                reservaBuscar.setEstadoReserva(estadoReserva);
                break;
            }
        }
    }

    /**
     * Se crea la factura y su detalle, y se cambia el estado de la reserva
     * @param factura
     * @param idReserva
     * @return
     */
    public boolean confirmarReserva(Factura factura, String idReserva){

        DetalleFactura detalleFactura = new DetalleFactura();
        Reserva reserva = this.obtenerReserva(idReserva);
        if(reserva == null){
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Factura facturaPrueba = this.obtenerFactura(factura.getId());
        if(facturaPrueba != null){
            JOptionPane.showMessageDialog(null, "Ya existe un id con esta factura", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        factura.setTotal(reserva.getTarifaReserva());
        this.cambiarEstadoReserva(reserva.getIdReserva(),EstadoReserva.CONFIRMADA);
        detalleFactura.setIdFactura(factura.getId());
        detalleFactura.setReservas(reserva);
        this.listaDetallesFactura.add(detalleFactura);
        this.listaFacturas.add(factura);
        this.listaFacturas.add(factura);

        return  true;
    }

    /**
     * Se cancela el estado de la reserva y se libera la habitacion
     * @param idReserva
     * @return
     */
    public boolean cancelarReserva(String idReserva){

        Reserva reserva = this.obtenerReserva(idReserva);
        if(reserva == null){
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.cambiarEstadoReserva(idReserva,EstadoReserva.CANCELADA);
        this.cambiarEstadoHabitacion(reserva.getCodigoHabitacion(),EstadoHabitacion.DISPONIBLE);

        return true;
    }

    /**
     * Se pone la reserva como terminada y se libera la habitacion
     * @param idReserva
     * @return
     */

    public boolean terminarReserva(String idReserva){

        Reserva reserva = this.obtenerReserva(idReserva);
        if(reserva == null){
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(reserva.getEstadoReserva() != EstadoReserva.CONFIRMADA){
            JOptionPane.showMessageDialog(null, "La reserva debe estar previamente confirmada", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        this.cambiarEstadoReserva(idReserva,EstadoReserva.TERMINADA);
        this.cambiarEstadoHabitacion(reserva.getCodigoHabitacion(),EstadoHabitacion.DISPONIBLE);
        return true;
    }

    public boolean agregarFacturaSalida(Factura factura, String idReserva, ArrayList<Servicio> servicios){

        DetalleFactura detalleFactura = new DetalleFactura();
        Reserva reserva = this.obtenerReserva(idReserva);
        if(reserva == null){
            JOptionPane.showMessageDialog(null, "La reserva no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Factura facturaPrueba = this.obtenerFactura(factura.getId());
        if(facturaPrueba != null){
            JOptionPane.showMessageDialog(null, "Ya existe un id con esta factura", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Se calcula el total
        double total = 0;
        for (int i = 0; i < servicios.size(); i++) {
            total +=  servicios.get(i).getPrecio() ;
        }

        factura.setTotal(total);
        this.cambiarEstadoReserva(reserva.getIdReserva(),EstadoReserva.TERMINADA);
        this.cambiarEstadoHabitacion(reserva.getCodigoHabitacion(),EstadoHabitacion.DISPONIBLE);
        detalleFactura.setIdFactura(factura.getId());
        detalleFactura.setReservas(reserva);
        detalleFactura.setServicios(servicios);
        this.listaDetallesFactura.add(detalleFactura);
        this.listaFacturas.add(factura);
        this.listaFacturas.add(factura);

        return true;
    }

    public String listarFacturas(String idCliente){

        String mensaje = "";

        for (int i = 0; i < this.listaDetallesFactura.size(); i++) {

            DetalleFactura detalleFactura = this.listaDetallesFactura.get(i);
            //Se buscan las reservas que hizo el huesped
             if(detalleFactura.getReservas().getCodigoHuesped().equalsIgnoreCase(idCliente)){
                 Factura factura = this.obtenerFactura(detalleFactura.getIdFactura());
                 if(factura.getTipo() == TipoFactura.CHECKIN){
                     Reserva reserva = detalleFactura.getReservas();
                     mensaje += ("id factura:" + factura.getId() + "\n" +
                             "ciudad: " + factura.getCity() + "\n" +
                             "Departamento: " + factura.getDepartamento() + "\n" +
                             "Pais: " + factura.getPais() + "\n" +
                             "codigo postal" + factura.getPostalCode() + "\n" +
                             "Total: " + factura.getTotal() + "\n" +
                             "Habitacion : " + reserva.getCodigoHabitacion() + "\n" +
                             "Fecha entrada: " + reserva.getFechaEntrada() + "\n" +
                             "Fecha salida: " + reserva.getFechaSalida() + "\n" +
                             "Cantidad personas: " + reserva.getNumeroHuespedes() + "\n\n\n");

                 } else if(factura.getTipo() == TipoFactura.CHECKOUT){

                     mensaje += ("id factura:" + factura.getId() + "\n" +
                             "ciudad: " + factura.getCity() + "\n" +
                             "Departamento: " + factura.getDepartamento() + "\n" +
                             "Pais: " + factura.getPais() + "\n" +
                             "codigo postal: " + factura.getPostalCode() + "\n" +
                             "Total: " + factura.getTotal() + "\n");
                     ArrayList<Servicio> servicios =  detalleFactura.getServicios();
                     for (int j = 0; j < servicios.size(); j++){
                         Servicio servicio = servicios.get(j);
                         mensaje += "Servicio: " + servicio.getNombre() + " Costo: " + servicio.getPrecio() + "\n";
                     }
                     mensaje += "\n\n\n";
                 }



             }
        }
        return mensaje;
    }

    public Factura obtenerFactura(String idFactura){

        Factura factura = null;

        for (int i = 0; i < this.listaFacturas.size(); i++) {
            Factura fecturaBuscar = listaFacturas.get(i);

            if (fecturaBuscar.getId().equalsIgnoreCase(idFactura)) {
                factura = fecturaBuscar;
                break;
            }
        }

        return factura;

    }
}
