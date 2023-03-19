package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IniciarSesionOutlineStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(IniciarSesionOutlineStepDefinition.class);
    private WebDriver driver;

    @Given("que estoy en la pagina de inicio de sesion de ZonaFit desde {string}")
    public void queEstoyEnLaPaginaDeInicioDeSesionDeZonaFitDesde(String navegador) {

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

    @When("ingreso mi correo electrónico {string} y mi contraseña {string}")
    public void ingresoMiCorreoElectronicoYMiContrasena(String correo, String contrasena) {
        FormPage formPage = new FormPage(super.driver);
        formPage.ingresarCorreo(correo);
        formPage.ingresarContrasena(contrasena);

    }

    @When("hago clic en el botón Iniciar sesión")
    public void hagoClicEnElBotonIniciarSesion() {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickBotonIniciarSesion();
    }

    @Then("debo ser redirigido a mi cuenta de ZonaFit")
    public void deboSerRedirigidoAMiCuentaDeZonaFit() {
        FormPage formPage = new FormPage(super.driver);
        Assertions.assertTrue(formPage.confirmarRedireccionCuenta(), "No se redireccionó correctamente a la cuenta de ZonaFit");

    }
}