package com.sofkau.util;

public enum ValorTiempoEspera {
    CERO(0),
    CINCO(5),
    DIEZ(10),
    TREINTA (30),
    CUARENTA (40);


    private int valor;

    ValorTiempoEspera(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
