package com.sofkau.stepdefinitions;

import com.sofkau.page.FPageAsistenciaChrome;
import com.sofkau.page.FPageDisneyChrome;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class StepDisney extends WebUI {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepDisney.class));
    @Given("que necesito un paquete para dos adultos y dos menores por navegador {string}")
    public void queNecesitoUnPaqueteParaDosAdultosYDosMenoresPorNavegador(String navegador) {
        generalSetUp(navegador);
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("seleccione fecha y la informacion")
    public void seleccioneFechaYLaInformacion() throws InterruptedException{
        FPageDisneyChrome pageDisney = new FPageDisneyChrome(super.driver);
        pageDisney.closeLogin();
        pageDisney.selectedPage();
        pageDisney.fillAssistanceForm();
    }
    @Then("debo observar la reserva generada con exito")
    public void deboObservarLaReservaGeneradaConExito() {

    }

    //Scenario

    @Given("que necesito un paquete para dos adultos y un menor")
    public void queNecesitoUnPaqueteParaDosAdultosYUnMenor() {

    }
    @When("seleccione fecha y la informacion requerida")
    public void seleccioneFechaYLaInformacionRequerida() {

    }
    @Then("debo obtener la reserva generada con exito")
    public void deboObtenerLaReservaGeneradaConExito() {

    }
}
