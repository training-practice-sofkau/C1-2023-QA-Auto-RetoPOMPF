package com.sofka.model;

public class Facturacion {

    private String documento ;
    private String email;
    private String nombre;
    private String apellido;
    private String lugar1;
    private  String lugar2;
    private String direccion;
    private String direccion2;
    private String telefono;
    private String notas_adicionales;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLugar1() {
        return lugar1;
    }

    public void setLugar1(String lugar1) {
        this.lugar1 = lugar1;
    }

    public String getLugar2() {
        return lugar2;
    }

    public void setLugar2(String lugar2) {
        this.lugar2 = lugar2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotas_adicionales() {
        return notas_adicionales;
    }

    public void setNotas_adicionales(String notas_adicionales) {
        this.notas_adicionales = notas_adicionales;
    }
}
