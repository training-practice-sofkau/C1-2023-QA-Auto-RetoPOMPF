package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IniciarSesionStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(IniciarSesionStepDefinition.class);

    @Given("que estoy en la pagina principal de ZonaFit  desde {string}")
    public void queEstoyEnLaPaginaPrincipalDeZonaFitDesde(String navegador) {
        FormPage formPage = new FormPage(super.driver);
        try {
            if (navegador.equals("chrome")){
                generalSetUpChrome();
                LOGGER.info("Inicio de la Automatizacion");

            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("Inicio de la Automatizacion");
            }
            LOGGER.info("Inicio de la Automatizacion");
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("hago click en el boton de {string}")
    public void hagoClickEnElBotonDe(String button) {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickLoginButton();

    }
    @When("ingreso mi informacion personal valida en su campo correspondiente como direccion de correo electronico y contrasena")
    public void ingresoMiInformacionPersonalValidaEnSuCampoCorrespondienteComoDireccionDeCorreoElectronicoYContrasena() {
        FormPage formPage = new FormPage(super.driver);
        formPage.setEmaill("BobMarley@reggae.com");
        formPage.setPasswordd("azuca12345");

    }
    @When("hago click en el botonn de {string}")
    public void hagoClickEnElBotonnDe(String acceder) {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickAccederButton();

    }
    @Then("deberia ser redirigido a la pagina principal y visualizar el {string} de usuario")
    public void deberiaSerRedirigidoALaPaginaPrincipalYVisualizarElDeUsuario(String username) {
        username = "BOBMARLEY";
        FormPage formPage = new FormPage(super.driver);
        assertEquals(username, formPage.getUsername());
        driver.quit();

    }

}


