package com.sofkau.setup;


import org.apache.log4j.PropertyConfigurator;
import static com.sofka.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class RestApi {


    private void setUplog4jUrl() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue() );
    }

}
