package com.sofkau.stepdefinition;

import com.sofkau.pages.VueloFiltroPage;
import com.sofkau.pages.VueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class VueloFiltroStepDef extends WebUI {

    public static Logger LOGGER=Logger.getLogger(VueloFiltroStepDef.class);

    private Response response;

    @Given("que estoy en la pagina de Despegar.com.co en el navegador {string}")
    public void queEstoyEnLaPaginaDeDespegarComCo(String navegadorSelect) {
        generalSetUp(navegadorSelect);
        LOGGER.info("Inicio de la Automatizacion");

    }
    @When("busco y selecciono un vuelo de ida y vuelta para tres adultos")
    public void buscoYSeleccionoUnVueloDeIdaYVueltaParaTresAdultos() throws InterruptedException {
        VueloPage vueloPage = new VueloPage(super.driver);
        vueloPage.clickVuelo();

    }
    @When("Selecciono la aerolinea con la que deseo viajar")
    public void seleccionoLaAerolineaConLaQueDeseoViajar() throws InterruptedException {
        VueloFiltroPage vueloFiltroPage = new VueloFiltroPage(super.driver);
        vueloFiltroPage.fillMandatoryFields();

    }
    @Then("los resultados de busqueda muestran opciones de vuelo que cumplen con mis criterios de aerolinea")
    public void losResultadosDeBusquedaMuestranOpcionesDeVueloQueCumplenConMisCriteriosDeAerolinea() {

    }
}
