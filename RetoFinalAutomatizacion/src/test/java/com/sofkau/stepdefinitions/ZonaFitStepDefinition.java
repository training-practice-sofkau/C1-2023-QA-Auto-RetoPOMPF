package com.sofkau.stepdefinitions;

import com.sofkau.setup.WebUI;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.function.Try;

public class ZonaFitStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);

    //Scenario 1
    @Given("que el cliente esta en la pagina principal desde el {string}")
    public void queElClienteEstaEnLaPaginaPrincipalDesdeEl(String navegador) {
        try {
            if (navegador.equals("chrome")) {
                generalSetUpChrome();
                LOGGER.info("inicio de la automatizacion ");
            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("inicio de la automatizacion ");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("agrega productos al carrito")
    public void agregaProductosAlCarrito() {

    }
    @When("completa la informacion de envio y facturacion")
    public void completaLaInformacionDeEnvioYFacturacion() {

    }
    @Then("debera observar un mensaje de confirmacion de la compra")
    public void deberaObservarUnMensajeDeConfirmacionDeLaCompra() {

    }

    //Scenario 2
    @When("ingresa informacion insuficiente")
    public void ingresaInformacionInsuficiente() {

    }
    @Then("debera observar un mensaje pidiendo la informacion requerida")
    public void deberaObservarUnMensajePidiendoLaInformacionRequerida() {

    }

    //Scenario 3
    @When("completa la informacion de envio con un correo invalido")
    public void completaLaInformacionDeEnvioConUnCorreoInvalido() {

    }
    @Then("debera observar un mensaje de correo invalido")
    public void deberaObservarUnMensajeDeCorreoInvalido() {

    }




}
