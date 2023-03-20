package com.sofkau.setup;

import org.apache.log4j.PropertyConfigurator;

import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class ListaSerieMarvelStep {
    protected static String protocol = "https";
    protected static String host = "gateway.marvel.com";
    protected static String version = "v1";
    protected static String resourceType = "public";
    protected static String resourceSubtype = "series";
    protected static String apiKey = "808226567a307a28cb7baf585c3941d3";
    protected static long timestamp = 1;
    protected static String hash = "867b39a58fba3884fb2e3a30590ab044";

    protected void generalSetup() {
        setUpLog4j2();
        setUpBases();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    private void setUpBases() {
        //RestAssured.baseURI = BASE_URI;
        //RestAssured.basePath = BASE_PATH;

    }
}
