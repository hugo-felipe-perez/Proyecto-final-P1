package co.edu.uniquindio.proyectoFinal.Clases;

import java.util.ArrayList;

public class DetalleFactura {

    private String idFactura;

    private Reserva reservas;

    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();

    public DetalleFactura(){

    }
    public DetalleFactura(String idFactura, Reserva reservas, ArrayList<Servicio> servicios) {
        this.idFactura = idFactura;
        this.reservas = reservas;
        this.servicios = servicios;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Reserva getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
}
