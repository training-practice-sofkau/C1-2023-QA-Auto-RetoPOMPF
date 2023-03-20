package com.sofkau.util;

import java.time.Duration;

public enum LimitTimeWait {
    ONE_SECONDS(Duration.ofSeconds(1)),
    FIVE_SECONDS(Duration.ofSeconds(5)),
    TEN_SECONDS(Duration.ofSeconds(10)),
    THIRTY_SECONDS(Duration.ofSeconds(30)),
    ONE_MINUTE(Duration.ofSeconds(60));

    private final Duration duration;

    public Duration getDuration() {
        return duration;
    }

    LimitTimeWait(Duration duration) {
        this.duration = duration;
    }
}
