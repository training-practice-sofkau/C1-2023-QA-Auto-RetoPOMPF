package com.sofka.util;

import java.time.Duration;

public enum TimeWait {
    ONE_SECONDS(Duration.ofSeconds(1)),
    FIVE_SECONDS(Duration.ofSeconds(5)),
    TEN_SECONDS(Duration.ofSeconds(10)),
    THIRTY_SECONDS(Duration.ofSeconds(30)),
    ONE_MINUTE(Duration.ofSeconds(60));

    private final Duration time;

    public Duration getTime() {
        return time;
    }

    TimeWait(Duration time) {
        this.time = time;
    }
}
