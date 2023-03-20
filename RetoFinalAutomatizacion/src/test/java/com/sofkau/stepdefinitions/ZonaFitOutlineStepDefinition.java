package com.sofkau.stepdefinitions;

import com.sofkau.pages.OutlinePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitOutlineStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitOutlineStepDefinition.class);
    @Given("que el cliente se encuentra en la pagina principal desde el {string}")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalDesdeEl(String navegador) {
        try {
            if (navegador.equals("chrome")) {
                generalSetUpChrome();
                LOGGER.info("inicio de la automatizacion en chrome ");
            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("inicio de la automatizacion en edge ");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("navega hasta el formulario de suscribete a nuestro newsletter")
    public void navegaHastaElFormularioDeSuscribeteANuestroNewsletter() {
        try {
            OutlinePage outlinePage = new OutlinePage(super.driver);
            outlinePage.navegar();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("completa los campos con email {string}, nombre {string} y telefono {string}")
    public void completaLosCamposConEmailNombreYTelefono(String email, String nombre, String telefono) {
        try {
            OutlinePage outlinePage = new OutlinePage(super.driver);
            outlinePage.fillMandatoryFields(email, nombre, telefono);
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debe observar un mensaje de gracias por suscribirse")
    public void debeObservarUnMensajeDeGraciasPorSuscribirse() {

    }
}
