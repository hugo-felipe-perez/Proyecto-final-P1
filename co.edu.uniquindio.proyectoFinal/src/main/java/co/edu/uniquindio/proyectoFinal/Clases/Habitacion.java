package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.EstadoHabitacion;
import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoHabitacion;

public class Habitacion {

    private String Comodidades;

    private String codigo;
    private int capacidadPersonas;
    private double precioNoche;

    private TipoHabitacion tipoHabitacion;

    private EstadoHabitacion estadoHabitacion;

    public Habitacion () {

    }

    public Habitacion(String comodidades, String codigo, int capacidadPersonas, double precioNoche, TipoHabitacion tipoHabitacion, EstadoHabitacion estadoHabitacion) {
        Comodidades = comodidades;
        this.codigo = codigo;
        this.capacidadPersonas = capacidadPersonas;
        this.precioNoche = precioNoche;
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
    }

    public String getComodidades() {
        return Comodidades;
    }

    public void setComodidades(String comodidades) {
        Comodidades = comodidades;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "Comodidades='" + Comodidades + '\'' +
                ", codigo='" + codigo + '\'' +
                ", capacidadPersonas=" + capacidadPersonas +
                ", precioNoche=" + precioNoche +
                ", tipoHabitacion=" + tipoHabitacion +
                ", estadoHabitacion=" + estadoHabitacion +
                '}';
    }
}
