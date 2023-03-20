package com.sofka.stepdefinitions;

import com.sofka.pages.CompraCategoriaPage;
import com.sofka.pages.NewsLetterPage;
import com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CompraCategoriaStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);

    private CompraCategoriaPage compraCategoriaPage;

    @Given("que el cliente esta en la pagina de inicio con {string}")
    public void queElClienteEstaEnLaPaginaDeInicioCon(String navegador) {
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

    @When("agrega varios productos al carrito de la categoria de aminoacidos")
    public void agregaVariosProductosAlCarritoDeLaCategoriaDeAminoacidos() {
        try{
            compraCategoriaPage = new CompraCategoriaPage(driver);
            compraCategoriaPage.addProducts();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @When("completa los datos del formulario de facturacion")
    public void completaLosDatosDelFormularioDeFacturacion() {

    }

    @Then("mostrara un mensaje de confirmacion de la compra")
    public void mostraraUnMensajeDeConfirmacionDeLaCompra() {

    }
}
