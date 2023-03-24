package com.sofkau.stepdefinitions;

import com.sofkau.pages.VuelosPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VuelosStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(VuelosStepDefinition.class);

    @Given("que estoy en la pagina de despegar con el navegador {string}")
    public void queEstoyEnLaPaginaDeDespegarConElNavegador(String navegador) {
        try {
            generalSetup(navegador);
            LOGGER.info("Iniciando automatizacion");
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
    @Given("que necesito un vuelo con origen {string} y destino {string}")
    public void queNecesitoUnVueloConOrigenYDestino(String origen, String destino) throws InterruptedException {
        try {
            VuelosPage vuelosPage = new VuelosPage(super.driver);
            vuelosPage.navigateToVuelos();
            vuelosPage.selectOriginDestiny(origen, destino);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
    @When("seleccione el vuelo mas barato disponible")
    public void seleccioneElVueloMasBaratoDisponible() {
        try {
            VuelosPage vuelosPage = new VuelosPage(super.driver);
            vuelosPage.buscarVuelo();
            vuelosPage.fillForm();
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
    @Then("debe observar que el vuelo se ha reservado exitosamente")
    public void debeObservarQueElVueloSeHaReservadoExitosamente() {
        try {
            VuelosPage vuelosPage = new VuelosPage(super.driver);
            String actual = vuelosPage.getTextfinal();
            Assertions.assertEquals("\u00A1Genial! Ahora solo te falta realizar el pago.", actual);
            quiteDriver();
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
}
