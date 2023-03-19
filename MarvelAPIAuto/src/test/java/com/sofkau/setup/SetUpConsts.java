package com.sofkau.setup;

import java.util.ArrayList;
import java.util.Arrays;

public class SetUpConsts {
    // Params
    public static final String PARAMS = "?";
    // Param connector
    public static final String PARAM_CON = "&";
    // Timestamp
    public static final String TS = "ts=1";
    // Public key
    public static final String API_KEY = "apikey=5367531001099b4027a3d42dd60da88e";
    // MD5 hash composed of TS+Private key+Public key
    public static final String HASH = "hash=0399a62d1f4256fd31f30f3d87c1916c";
    // Marvel API URL
    public static final String URL = "http://gateway.marvel.com/v1/public%s";
    // Events Slug
    public static final String EVENTS_SLUG = "/events";
    // Characters Slug
    public static final String CHARACTERS_SLUG = "/characters";
    // ID's of events
    public static final ArrayList<Integer> EVENT_ID = new ArrayList<Integer>(
                                                            Arrays.asList(116, 227, 229, 231, 233, 234, 235, 238, 239,
                                                                          240, 293, 296, 303, 310, 314, 318, 320, 322,
                                                                          329, 330));
    // ID's of characters
    public static final ArrayList<Integer> CHARACTER_ID = new ArrayList<Integer>(
                                                                Arrays.asList(1009158, 1009164, 1009165, 1009175,
                                                                              1009199, 1009219, 1009220, 1009229,
                                                                              1009233, 1009243, 1009257, 1009267,
                                                                              1009277, 1009310, 1009313, 1009318,
                                                                              1009337, 1009536, 1010678, 1012478));
    // Event ID routes
    public static final String EVENT_ROUTE = "data.results.id";
    // Character ID routes in an event
    public static final String CHARACTER_ROUTE = "data.results.id";
}