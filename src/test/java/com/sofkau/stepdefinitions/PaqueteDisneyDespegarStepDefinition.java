package com.sofkau.stepdefinitions;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class PaqueteDisneyDespegarStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(PaqueteDisneyDespegarStepDefinition.class);

    @Given("el usuario esta en la pagina despegar seccion Disney")
    public void el_usuario_esta_en_la_pagina_despegar_seccion_disney(String navegador) {
        generalSetup(navegador);
        LOGGER.warn("Inicio de la Automatizacion");

    }
    @When("el usuario elige la fecha de entrada y registra la informacion")
    public void el_usuario_elige_la_fecha_de_entrada_y_registra_la_informacion() {

    }
    @Then("deberaa obtener un mensaje de confirmacion de la reserva")
    public void deberaa_obtener_un_mensaje_de_confirmacion_de_la_reserva() {

    }

    //Scenario dos
    @Given("el usuario esta en la pagina despegar modulo Disney")
    public void el_usuario_esta_en_la_pagina_despegar_modulo_disney() {

    }
    @When("el usuario elige la fecha  y registra la informacion solicitada")
    public void el_usuario_elige_la_fecha_y_registra_la_informacion_solicitada() {

    }
    @Then("deberia mostrar un mensaje de confirmacion de la reserva")
    public void deberia_mostrar_un_mensaje_de_confirmacion_de_la_reserva() {

    }
}
