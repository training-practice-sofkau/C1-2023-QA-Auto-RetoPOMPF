package com.sofkau.models;

public class InformacionFormularioComprarVuelo {
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroCelular;
    private String numeroDocumento;

    private String nombreFactura;
    private String apellidoFactura;
    private String numeroDeIdentificacionFactura;
    private String direccionFactura;
    private String Oringen;
    private String Destino;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreFactura() {
        return nombreFactura;
    }

    public void setNombreFactura(String nombreFactura) {
        this.nombreFactura = nombreFactura;
    }

    public String getApellidoFactura() {
        return apellidoFactura;
    }

    public void setApellidoFactura(String apellidoFactura) {
        this.apellidoFactura = apellidoFactura;
    }

    public String getNumeroDeIdentificacionFactura() {
        return numeroDeIdentificacionFactura;
    }

    public void setNumeroDeIdentificacionFactura(String numeroDeIdentificacionFactura) {
        this.numeroDeIdentificacionFactura = numeroDeIdentificacionFactura;
    }

    public String getDireccionFactura() {
        return direccionFactura;
    }

    public void setDireccionFactura(String direccionFactura) {
        this.direccionFactura = direccionFactura;
    }

    public String getOringen() {
        return Oringen;
    }

    public void setOringen(String oringen) {
        Oringen = oringen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public InformacionFormularioComprarVuelo() {
    }


    public InformacionFormularioComprarVuelo(String nombre, String apellido, String correo, String numeroCelular, String numeroDocumento, String nombreFactura, String apellidoFactura, String numeroDeIdentificacionFactura, String direccionFactura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.numeroDocumento = numeroDocumento;
        this.nombreFactura = nombreFactura;
        this.apellidoFactura = apellidoFactura;
        this.numeroDeIdentificacionFactura = numeroDeIdentificacionFactura;
        this.direccionFactura = direccionFactura;
    }
}
