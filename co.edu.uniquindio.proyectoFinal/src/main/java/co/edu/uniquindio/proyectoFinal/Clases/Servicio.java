package co.edu.uniquindio.proyectoFinal.Clases;

public class Servicio {

    public String nombre;

    public double precio;
    public Servicio(){

    }

    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
