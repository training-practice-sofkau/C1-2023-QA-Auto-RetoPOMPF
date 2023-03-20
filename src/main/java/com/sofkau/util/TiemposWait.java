package com.sofkau.util;

public enum TiemposWait {

    ONE_SECONDS(1),

    FIVE_SECONDS(5),

    TEN_SECONDS(90);

    private final int value;

    public int getValue() {
        return value;
    }

    TiemposWait(int value) {
        this.value = value;
    }

}
