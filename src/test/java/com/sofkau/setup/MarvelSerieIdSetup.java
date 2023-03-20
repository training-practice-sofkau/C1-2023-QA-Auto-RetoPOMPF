package com.sofkau.setup;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class MarvelSerieIdSetup {


    public static final String APIMARVEL_URL="https://gateway.marvel.com/";

    protected void generalSetup() {
        setUpLog4j2();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


}
