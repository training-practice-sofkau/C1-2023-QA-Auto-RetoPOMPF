package com.sofka.stepdefinitions;

import com.sofka.pages.CompraCategoriaPage;
import com.sofka.pages.InicioSesionPage;
import com.sofka.pages.LocatorPage;
import com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class InicioSesionStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);

    private InicioSesionPage inicioSesionPage;

    @Given("que el cliente se encuentra en la pagina de inicio de sesion de ZonaFit con {string}")
    public void queElClienteSeEncuentraEnLaPaginaDeInicioDeSesionDeZonaFitCon(String navegador) {
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

    @When("ingresa el correo electronico {string} y la contrasena {string} posteriormente presiona el boton Iniciar Sesion")
    public void ingresaElCorreoElectronicoYLaContrasenaPosteriormentePresionaElBotonIniciarSesion(String correo, String contrasena) {
        try{
            inicioSesionPage = new InicioSesionPage(driver);
            inicioSesionPage.formLogin(correo, contrasena);
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @Then("mostrara su informacion personal y realizar compras")
    public void mostraraSuInformacionPersonalYRealizarCompras() {
        try{
            String expectedMessage = "Hola";
            inicioSesionPage = new InicioSesionPage(driver);
            String currentMessage = inicioSesionPage.getConfirmationMessage(driver).getText().trim();
            Assertions.assertEquals(expectedMessage, currentMessage);
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(),exception);
        }
    }
}