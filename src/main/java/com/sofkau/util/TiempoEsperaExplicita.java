package com.sofkau.util;

public enum TiempoEsperaExplicita {
    UN_SEGUNDO(1),
    CINCO_SEGUNDO(5),
    NUEVE_SEGUNDO(9),
    TREINTA_SEGUNDO(30),
    SESENTA_SEGUNDO(60);
    private final int value;
    public int getValue(){
        return value;
    }

    TiempoEsperaExplicita(int value) {
        this.value = value;
    }
}
