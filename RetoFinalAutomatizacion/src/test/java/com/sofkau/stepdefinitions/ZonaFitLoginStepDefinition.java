package com.sofkau.stepdefinitions;

import com.sofkau.pages.LoginPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitLoginStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitLoginStepDefinition.class);
    //scenario 1
    @Given("que el usuario esta en la pagina principal desde el {string}")
    public void queElUsuarioEstaEnLaPaginaPrincipalDesdeEl(String navegador) {
        try {
            if (navegador.equals("chrome")) {
                generalSetUpChrome();
                LOGGER.info("inicio de la automatizacion en chrome ");
            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("inicio de la automatizacion en edge ");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("navega hasta la opcion de inicio de sesion")
    public void navegaHastaLaOpcionDeInicioDeSesion() {
        try {
            LoginPage loginPage = new LoginPage(super.driver);
            loginPage.navegar();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("ingresa las credenciales correctas")
    public void ingresaLasCredencialesCorrectas() {
        try {
            LoginPage loginPage = new LoginPage(super.driver);
            loginPage.acceder();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debera redireccionarse a su perfil")
    public void deberaRedireccionarseASuPerfil() {

    }

    //scenario 2
    @When("ingresa las credenciales con una password incorrecto")
    public void ingresaLasCredencialesConUnaPasswordIncorrecto() {
        try {
            LoginPage loginPage = new LoginPage(super.driver);
            loginPage.accederInvalido();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debera observar un mensaje de error")
    public void deberaObservarUnMensajeDeError() {

    }


}
