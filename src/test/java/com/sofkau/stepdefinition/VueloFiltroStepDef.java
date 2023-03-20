package com.sofkau.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class VueloFiltroStepDef {

    public static Logger LOGGER=Logger.getLogger(VueloFiltroStepDef.class);

    private Response response;

    @Given("que estoy en la pagina de Despegar.com.co")
    public void queEstoyEnLaPaginaDeDespegarComCo() {

    }
    @When("busco y selecciono un vuelo de ida y vuelta para tres adultos")
    public void buscoYSeleccionoUnVueloDeIdaYVueltaParaTresAdultos() {

    }
    @When("Selecciono la aerolinea con la que deseo viajar")
    public void seleccionoLaAerolineaConLaQueDeseoViajar() {

    }
    @Then("los resultados de busqueda muestran opciones de vuelo que cumplen con mis criterios de aerolinea")
    public void losResultadosDeBusquedaMuestranOpcionesDeVueloQueCumplenConMisCriteriosDeAerolinea() {

    }
}
