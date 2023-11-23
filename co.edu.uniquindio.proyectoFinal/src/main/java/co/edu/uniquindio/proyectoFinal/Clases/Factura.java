package co.edu.uniquindio.proyectoFinal.Clases;

import co.edu.uniquindio.proyectoFinal.enumeraciones.TipoFactura;

public class Factura {

    private String id;
    private String city;

    private String departamento;

    private String postalCode;

    private String pais;

    private double total;

    private TipoFactura tipo;

    public Factura(){

    }
    public Factura(String id,String city, String departamento, String postalCode, String pais, double total, TipoFactura tipo) {
        this.city = city;
        this.departamento = departamento;
        this.postalCode = postalCode;
        this.pais = pais;
        this.total = total;
        this.tipo = tipo;
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoFactura getTipo() {
        return tipo;
    }

    public void setTipo(TipoFactura tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
