package com.sofka.util;

public enum TimeWait {
    DIEZ_SEGUNDOS(10),
    VEINTE_SEGUNDOS(20),
    TREINTA_SEGUNDOS(30);

    private final int value;

    TimeWait(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
