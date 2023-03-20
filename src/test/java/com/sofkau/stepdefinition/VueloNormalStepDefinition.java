package com.sofkau.stepdefinition;

import com.sofkau.pages.VueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static org.python.util.jython.logger;


public class VueloNormalStepDefinition extends WebUI {

    public static Logger LOGGER=Logger.getLogger(VueloNormalStepDefinition.class);

    private Response response;



    @Given("que estoy en la pagina de Despegar.com.co en navegador {string}")
    public void queEstoyEnLaPaginaDeDespegarComCoEnNavegador(String navegadorSelect) {
        generalSetUp(navegadorSelect);
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
    public void deboRecibirUnMensajeQueIndiqueQuePuedoPagarATravesDePSE() throws InterruptedException {

        VueloPage vueloPage = new VueloPage(super.driver);

        try {
            String expectedMessage = "\u00A1Genial! Ahora solo te falta realizar el pago.";
            String actualMessage = vueloPage.verMensaje();
            logger.info(actualMessage);

            Assert.assertEquals(expectedMessage, actualMessage);
            logger.info("La prueba ha pasado. Se encontro el mensaje esperado: " + actualMessage);

        } catch (AssertionError e) {
            LOGGER.error("La prueba fallo. Error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Ocurrio un error durante la ejecucion de la prueba. Error: " + e.getMessage());
            throw e;
        } finally {
            quiteDriver();
        }

    }


}
