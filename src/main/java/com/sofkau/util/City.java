package com.sofkau.util;

public enum City {

        SANJAVIER_ANT("Sabaneta"),
        SOPO_CUN("Sopo"),
        BRUSELAS_HUI("Bruselas"),
        RIOSUCIO_CAL("Riosucio"),
        IBAGUE_TOL("Tolima");

        private final String value;

        public String getValue () {
            return value;
        }

    City (String value) {
            this.value = value;
        }

}
