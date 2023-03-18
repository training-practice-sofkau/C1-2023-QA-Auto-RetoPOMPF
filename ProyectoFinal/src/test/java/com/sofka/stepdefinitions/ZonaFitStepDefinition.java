package com.sofka.stepdefinitions;

import com.sofka.pages.CommonActionOnPage;
import com.sofka.pages.LocatorPage;
import com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);

    private LocatorPage locatorPage;

    @Given("que el cliente se encuentra en la pagina principal con {string}")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalCon(String navegador) {

        try{
            if (navegador.equals("chrome")){
                generalSetUpGoogleChrome();
                LOGGER.info("Inicia la automatización");
            } else if (navegador.equals("edge")){
                generalSetUpMicrosoftEdge();
                LOGGER.info("Inicia la automatización");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @When("agrega varios productos al carrito")
    public void agregaVariosProductosAlCarrito() {
        locatorPage = new LocatorPage(driver);
        locatorPage.navegar();
    }

    @When("completa la informacion del formulario de facturacion")
    public void completaLaInformacionDelFormularioDeFacturacion() {
        locatorPage.formBill();
    }

    @Then("mostrara un mensaje confirmando la compra")
    public void mostraraUnMensajeConfirmandoLaCompra() {

    }

    @When("completa un campo con un dato invalido")
    public void completaUnCampoConUnDatoInvalido() {

    }

    @Then("mostrara un mensaje de error indicando el campo obligatorio al ingresar un dato invalido")
    public void mostraraUnMensajeDeErrorIndicandoElCampoObligatorioAlIngresarUnDatoInvalido() {

    }
}