package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;

public class FlujoDeCompraStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(IniciarSesionOutlineStepDefinition.class);
    @Given("estoy en la pagina principal de ZonaFit usando {string}")
    public void estoyEnLaPaginaPrincipalDeZonaFitUsando(String navegador) {
        FormPage formPage= new FormPage( super.driver);
        try {
            if (navegador.equals("chrome")){
                generalSetUpChrome();
                LOGGER.info("Inicio de la Automatizacion");

            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("Inicio de la Automatizacion");
            }

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("selecciono y anado productos al carrito de compras")
    public void seleccionoYAnadoProductosAlCarritoDeCompras() {
        FormPage formPage = new FormPage(super.driver);
        formPage.scrollDown();

    }
    @When("ingreso mis datos personales y el metodo de pago")
    public void ingresoMisDatosPersonalesYElMetodoDePago() {

    }
    @Then("debo ver un mensaje de confirmacion de compra exitosa.")
    public void deboVerUnMensajeDeConfirmacionDeCompraExitosa() {

    }
}
