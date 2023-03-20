package com.sofkau.util;

import java.time.Duration;

public enum LimitTimeWait {
    ONE_SECOND(Duration.ofSeconds(1)),
    FIVE_SECONDS(Duration.ofSeconds(5)),
    TEN_SECONDS(Duration.ofSeconds(10)),
    THIRTY_SECONDS(Duration.ofSeconds(30)),
    ONE_MINUTE(Duration.ofSeconds(60));

    private final  Duration value;

    public Duration getValue(){
        return value;
    }

    LimitTimeWait(Duration value){
        this.value = value;
    }

}
