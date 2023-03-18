package com.sofkau.stepdefinitios;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class VueloStepDefinition {
    private Response response;
    private String requeestBody;

    @Given("el usuario esta en la pagina registro de vuelo")
    public void el_usuario_esta_en_la_pagina_registro_de_vuelo() {

    }
    @When("selecciona lugar origen y de destino")
    public void selecciona_lugar_origen_y_de_destino() throws InterruptedException {

    }
    @Then("deberia obtener un mensaje de confirmacion de la reserva")
    public void deberia_obtener_un_mensaje_de_confirmacion_de_la_reserva() {

    }

    //Scenario dos
    @Given("el usuario esta en la pagina registro formulario de vuelo")
    public void el_usuario_esta_en_la_pagina_registro_formulario_de_vuelo() {

    }
    @When("selecciona una fecha no disponible")
    public void selecciona_una_fecha_no_disponible() {

    }
    @Then("deberia obtener un mensaje vuelos no disponibles")
    public void deberia_obtener_un_mensaje_vuelos_no_disponibles() {

    }

}
