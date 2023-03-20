package com.sofkau.model;

public class Usuario {
    private String nombre;
    private String apellido;

    private String documento;

    private String lugarOrigen;
    private String lugarDestino;

    private String email;
    private String confirmarEmail;
    private String direccion;

    private  String telefono;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String documento, String lugarOrigen, String lugarDestino, String email, String confirmarEmail, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.email = email;
        this.confirmarEmail = confirmarEmail;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String nombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String telefono() {
        return telefono;
    }

    public Usuario setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String apellido() {
        return apellido;
    }

    public Usuario setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String documento() {
        return documento;
    }

    public Usuario setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public String lugarOrigen() {
        return lugarOrigen;
    }

    public Usuario setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
        return this;
    }

    public String lugarDestino() {
        return lugarDestino;
    }

    public Usuario setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
        return this;
    }

    public String email() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String confirmarEmail() {
        return confirmarEmail;
    }

    public Usuario setConfirmarEmail(String confirmarEmail) {
        this.confirmarEmail = confirmarEmail;
        return this;
    }

    public String direccion() {
        return direccion;
    }

    public Usuario setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
}
