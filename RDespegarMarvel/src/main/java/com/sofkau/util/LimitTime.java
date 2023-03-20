package com.sofkau.util;

public enum LimitTime {
    ONE_SECONDS(1),
    FIVE_SECONDS(5),
    TEN_SECONDS(10),
    THIRTY_SECONDS(80);

    private final int value;

    LimitTime(int value){
        this.value = value;
    }

    public int getValue(){
        return  value;
    }

}
