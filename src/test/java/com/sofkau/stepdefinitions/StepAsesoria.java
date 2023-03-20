package com.sofkau.stepdefinitions;

import com.sofkau.pages.common.CommonActionPages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;
import java.util.logging.Logger;
public class StepAsesoria extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepAsesoria.class));
    private CommonActionPages commonActionOnPages;

    @Given("que estoy en la pagina principal de zonafit")
    public void queEstoyEnLaPaginaPrincipalDeZonafit() {
        try {
            generalSetUp();
            commonActionOnPages = new CommonActionPages(driver);
            LOGGER.info("Se ha iniciado el driver y se ha accedido a la página de ZonaFit");
        } catch (Exception e) {
            LOGGER.warning("Ha ocurrido un error al acceder a la página principal de ZonaFit: " + e.getMessage());
            Assert.fail("No se ha podido acceder a la página principal de ZonaFit");
        }
    }

    @When("doy clic en el boton flotante ubicado en la parte derecha de la pantalla")
    public void doyClicEnElBotonFlotanteUbicadoEnLaParteDerechaDeLaPantalla() {
        try {
            commonActionOnPages.clickBotonWhatsapp();
            LOGGER.info("Se ha hecho clic en el botón de WhatsApp");
        } catch (Exception e) {
            LOGGER.warning("Ha ocurrido un error al hacer clic en el botón de WhatsApp: " + e.getMessage());
            Assert.fail("No se ha podido hacer clic en el botón de WhatsApp");
        }
    }

    @When("selecciono la opcion Necesitas asesoria")
    public void seleccionoLaOpcionNecesitasAsesoria() {
        try {
            commonActionOnPages.clickBotonNecesitasAsesoria();
            LOGGER.info("Se ha hecho clic en la opción 'Necesitas asesoría'");
        } catch (Exception e) {
            LOGGER.warning("Ha ocurrido un error al hacer clic en la opción 'Necesitas asesoría': " + e.getMessage());
            Assert.fail("No se ha podido hacer clic en la opción 'Necesitas asesoría'");
        }
    }

    @Then("soy redirigido a la pagina para la asesoria")
    public void soyRedirigidoALaPaginaParaLaAsesoria() {
        try {
            // Obtener las handles de todas las pestañas abiertas por el navegador
            Set<String> handles = driver.getWindowHandles();
            // Cambiar el foco del driver a la pestaña de la asesoría
            for (String handle : handles) {
                if (!handle.equals(driver.getWindowHandle())) {
                    driver.switchTo().window(handle);
                }
            }
            // Comparar la URL actual con la URL esperada
            String expectedUrl = "https://api.whatsapp.com/send/?phone=573054596254&text=Hola+Zona+FIT%2C+quisiera+informaci%C3%B3n+sobre+Tenemos+la+" +
                    "mayor+variedad+en+nutrici%C3%B3n+deportiva+-+Zona+FIT+Colombia&type=phone_number&app_absent=0";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, actualUrl, "La página actual no es la de asesoría");
            LOGGER.info("La página actual es la de asesoría");
        } catch (Exception e) {
            LOGGER.warning("Ha ocurrido un error al verificar la redirección a la página de asesoría: " + e.getMessage());
            Assert.fail("No se ha redirigido correctamente a la página de asesoría");
        }
    }
}



