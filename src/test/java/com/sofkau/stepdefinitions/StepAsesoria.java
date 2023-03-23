package com.sofkau.stepdefinitions;

import com.sofkau.pages.common.CommonActionPages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class StepAsesoria extends WebUI {
    public static Logger LOGGER = Logger.getLogger((StepAsesoria.class));
    private CommonActionPages commonActionOnPages;

    @Given("que estoy en la pagina principal de zonafit")
    public void queEstoyEnLaPaginaPrincipalDeZonafit() {
        try {
            generalSetUp();
            commonActionOnPages = new CommonActionPages(driver);
            LOGGER.info("Se ha iniciado el driver y se ha accedido a la página de ZonaFit");
        } catch (Exception e) {
            LOGGER.warn("Ha ocurrido un error al acceder a la página principal de ZonaFit: " + e.getMessage());
            Assert.fail("No se ha podido acceder a la página principal de ZonaFit");
        }
    }

    @When("doy clic en el boton flotante ubicado en la parte derecha de la pantalla")
    public void doyClicEnElBotonFlotanteUbicadoEnLaParteDerechaDeLaPantalla() {
        try {
            commonActionOnPages.clickBotonWhatsapp();
            LOGGER.info("Se ha hecho clic en el botón de WhatsApp");
        } catch (Exception e) {
            LOGGER.warn("Ha ocurrido un error al hacer clic en el botón de WhatsApp: " + e.getMessage());
            Assert.fail("No se ha podido hacer clic en el botón de WhatsApp");
        }
    }

    @When("selecciono la opcion Necesitas asesoria")
    public void seleccionoLaOpcionNecesitasAsesoria() {
        try {
            commonActionOnPages.clickBotonNecesitasAsesoria();
<<<<<<< HEAD
            Thread.sleep(10000);
=======
            Thread.sleep(50000);
>>>>>>> main
            LOGGER.info("Se ha hecho clic en la opción 'Necesitas asesoría'");
        } catch (Exception e) {
            LOGGER.warn("Ha ocurrido un error al hacer clic en la opción 'Necesitas asesoría': " + e.getMessage());
            Assert.fail("No se ha podido hacer clic en la opción 'Necesitas asesoría'");
        }
    }

    @Then("soy redirigido a la pagina para la asesoria")
    public void soyRedirigidoALaPaginaParaLaAsesoria() {
        // Obtener una lista de las pestañas abiertas en el navegador
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Cambiar a la última pestaña de la lista (la que se abrió al hacer clic en el botón "Necesitas asesoría")
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        // Obtener la URL actual
        String currentUrl = driver.getCurrentUrl();
        // Verificar que la URL actual sea igual a la URL de la página de WhatsApp
        String expectedUrl = "https://api.whatsapp.com/send/?phone=573054596254&text=Hola+Zona+FIT%2C+quisiera+informaci%C3%B3n+sobre+Tenemos+la+mayor+variedad+en+nutrici%C3%B3n+deportiva+-+Zona+FIT+Colombia&type=phone_number&app_absent=0";
        LOGGER.info("Valor esperado: " + expectedUrl);
        LOGGER.info("Valor actual: " + currentUrl);
        Assert.assertEquals(currentUrl, expectedUrl);
        quitDriver();
    }


<<<<<<< HEAD
=======



>>>>>>> main
}



