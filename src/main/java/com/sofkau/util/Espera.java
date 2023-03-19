package com.sofkau.util;

public enum Espera {

    CERO(0),
    CINCO(5),
    DIEZ(10),
    TREINTA (30),
    CUARENTA (40);


    private int valor;

    Espera(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
