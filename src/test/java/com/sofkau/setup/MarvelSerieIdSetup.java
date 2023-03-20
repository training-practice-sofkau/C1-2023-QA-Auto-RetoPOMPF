package com.sofkau.setup;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class MarvelSerieIdSetup {

    protected static String protocol = "https";
    protected static String host = "gateway.marvel.com";
    protected static String version = "v1";
    protected static String resourceType = "public";
    protected static String resourceSubtype = "series";
    protected static String id;
    protected static String apiKey = "d8b3a1f603bf809767844474bdeb690d";
    protected static long timestamp = 1;
    protected static String hash = "a9c04f1195b3321b57632e6421449c29";
    public static final String APIMARVEL_URL="https://gateway.marvel.com/";

    protected void generalSetup() {
        setUpLog4j2();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


}
