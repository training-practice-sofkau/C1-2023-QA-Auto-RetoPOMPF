package com.sofkau.models;

public class Usuario {
    private String nombre;
    private String apellido;
    private String pais;
    private String documento;
    private int diaSalida;
    private int diaLlegada;
    private String correo;
    private String numero;

    private String direccion;

    public Usuario() {
    }


    public Usuario(String nombre, String apellido, String pais, String documento, int diaSalida, int diaLlegada, String correo, String numero, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.documento = documento;
        this.diaSalida = diaSalida;
        this.diaLlegada = diaLlegada;
        this.correo = correo;
        this.numero = numero;
        this.direccion = direccion;
    }


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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(int diaSalida) {
        this.diaSalida = diaSalida;
    }

    public int getDiaLlegada() {
        return diaLlegada;
    }

    public void setDiaLlegada(int diaLlegada) {
        this.diaLlegada = diaLlegada;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
