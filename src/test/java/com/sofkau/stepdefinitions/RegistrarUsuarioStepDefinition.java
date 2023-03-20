package com.sofkau.stepdefinitions;

import com.sofkau.pages.CommonActionOnPages;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrarUsuarioStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(RegistrarUsuarioStepDefinition.class);

    @Given("que estoy en la pagina de registro de ZonaFit desde {string}")
    public void queEstoyEnLaPaginaDeRegistroDeZonaFitDesde(String navegador) {
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

    @When("hago clic en el boton de {string}")
    public void hagoClicEnElBotonDe(String button) {
        FormPage formPage = new FormPage(super.driver);
        if (button.equals("acceder/registrarse")) {
            formPage.clickAccederRegistrarseButton();
        } else if (button.equals("registrarse")) {
            formPage.clickRegistrarseButton();
        }
    }
    @When("ingreso mi informacion personal valida en su campo correspondiente como direccion de correo electronico, contrasena y confirmar contrasena.")
    public void ingresoMiInformacionPersonalValidaEnSuCampoCorrespondienteComoDireccionDeCorreoElectronicoContrasenaYConfirmarContrasena() {
        FormPage formPage = new FormPage(super.driver);
        formPage.setEmail("BobMarley5@reggae.com");
        formPage.setPassword("azuca12345");
        formPage.setConfirmPassword("azuca12345");
    }


    @Then("debo recibir un mensaje de confirmacion de {string}")
    public void deboRecibirUnMensajeDeConfirmacionDe(String confirmationMessage) {
        WebElement miCuentaButton = driver.findElement(By.xpath("(//a[@title='Mi cuenta'])[1]"));
        Assertions.assertTrue(miCuentaButton.isDisplayed(), "El botón 'Mi cuenta' no se muestra después de registrarse");
    }
}

