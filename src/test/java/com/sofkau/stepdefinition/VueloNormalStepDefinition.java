package com.sofkau.stepdefinition;

import com.sofkau.pages.VueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class VueloNormalStepDefinition extends WebUI {

    public static Logger LOGGER=Logger.getLogger(VueloNormalStepDefinition.class);

    @Given("que estoy en la pagina de Despegar.com.co")
    public void queEstoyEnLaPaginaDeDespegarComCo() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion");

    }
    @When("busco, selecciono un vuelo de ida y vuelta desde origen a destino, fechas para dos adultos y un menor")
    public void buscoSeleccionoUnVueloDeIdaYVueltaDesdeOrigenADestinoFechasParaDosAdultosYUnMenor() throws InterruptedException {
        VueloPage vueloPage = new VueloPage(super.driver);
        vueloPage.clickVuelo();

    }
    @When("proporciono la informacion necesaria")
    public void proporcionoLaInformacionNecesaria() throws InterruptedException {
        VueloPage vueloPage = new VueloPage(super.driver);
        vueloPage.fillMandatoryFields();

    }
    @Then("debo recibir un mensaje que indique que puedo pagar a traves de PSE")
    public void deboRecibirUnMensajeQueIndiqueQuePuedoPagarATravesDePSE() {

    }
}
