package com.sofkau.models;

public class Pasajero {
        private String nombres;
        private String apellidos;
        private String documento;
        private String correo;
        private String telefono;

        private String direccion;

        public Pasajero(String nombres, String apellidos, String documento, String correo, String telefono, String direccion) {
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.documento = documento;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;
        }

        public Pasajero() {

        }


    public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
}
