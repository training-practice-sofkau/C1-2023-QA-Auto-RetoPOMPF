package com.sofkau.stepdefinitions;

import com.sofkau.pages.common.CommonActionOnpages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.logging.Logger;
public class StepAsesoria extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepAsesoria.class));
    private CommonActionOnpages commonActionOnPages;

    @Given("que estoy en la pagina principal de zonafit")
    public void queEstoyEnLaPaginaPrincipalDeZonafit() {
        generalSetUp();
        commonActionOnPages = new CommonActionOnpages(driver);
        LOGGER.info("Se ha iniciado el driver y se ha accedido a la página de ZonaFit");
    }

    @When("doy clic en el boton flotante ubicado en la parte derecha de la pantalla")
    public void doyClicEnElBotonFlotanteUbicadoEnLaParteDerechaDeLaPantalla() {
        commonActionOnPages.clickBotonWhatsapp();
        LOGGER.info("Se ha hecho clic en el botón de WhatsApp");
    }

    @When("selecciono la opcion Necesitas asesoria")
    public void seleccionoLaOpcionNecesitasAsesoria() {
        commonActionOnPages.clickBotonNecesitasAsesoria();
        LOGGER.info("Se ha hecho clic en la opción 'Necesitas asesoría'");
    }

    @Then("soy redirigido a la pagina para la asesoria")
    public void soyRedirigidoALaPaginaParaLaAsesoria() {
        String expectedUrl = "https://zonafit.co//";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        LOGGER.info("La pagina actual es la de asesoria");
    }
}


