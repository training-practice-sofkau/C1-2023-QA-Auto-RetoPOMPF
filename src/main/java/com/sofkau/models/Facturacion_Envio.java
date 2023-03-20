package com.sofkau.models;

public class Facturacion_Envio {
        private String Numerodocumento ;
        private String email;
        private String nombre;
        private String apellido;
        private String departamento;
        private  String ciudad;
        private String direccion;
        private String complementoDireccion;
        private String celular;
        private String NotasdelPedido;

        public String getDocumento() {
            return Numerodocumento;
        }

        public void setDocumento(String documento) {
            this.Numerodocumento = documento;
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
            return departamento;
        }

        public void setLugar1(String lugar1) {
            this.departamento = lugar1;
        }

        public String getLugar2() {
            return ciudad;
        }

        public void setLugar2(String lugar2) {
            this.ciudad = lugar2;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getDireccion2() {
            return complementoDireccion;
        }

        public void setDireccion2(String direccion2) {
            this.complementoDireccion = direccion2;
        }

        public String getTelefono() {
            return celular;
        }

        public void setTelefono(String telefono) {
            this.celular = telefono;
        }

        public String getNotas_adicionales() {
            return NotasdelPedido;
        }

        public void setNotas_adicionales(String notas_adicionales) {
            this.NotasdelPedido = notas_adicionales;
        }

    }
