package com.sofka.stepdefinitions;

import com.sofka.pages.NewsLetterPage;
import com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class NewsLetterDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);

    private NewsLetterPage newsLetterPage;

    @Given("que el cliente esta en la pagina principal con {string}")
    public void queElClienteEstaEnLaPaginaPrincipalCon(String navegador) {
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

    @When("ingresa credenciales posteriormente envia el formulario")
    public void ingresaCredencialesPosteriormenteEnviaElFormulario() {
        try{
            newsLetterPage = new NewsLetterPage(driver);
            newsLetterPage.formComplete();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @Then("mostrara un mensaje de confirmacion indicando que ha sido suscrito al newsletter")
    public void mostraraUnMensajeDeConfirmacionIndicandoQueHaSidoSuscritoAlNewsletter() {

    }
}
