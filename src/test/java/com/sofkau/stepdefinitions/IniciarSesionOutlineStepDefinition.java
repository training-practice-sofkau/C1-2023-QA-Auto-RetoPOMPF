package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IniciarSesionOutlineStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(IniciarSesionOutlineStepDefinition.class);
    @Given("que estoy en la pagina de inicio de sesion de ZonaFit desde {string}")
    public void queEstoyEnLaPaginaDeInicioDeSesionDeZonaFitDesde(String navegador) {
        FormPage formPage= new FormPage( super.driver);
        try {
            if (navegador.equals("chrome")){
                generalSetUpChrome();
                LOGGER.info("Inicio de la Automatizacion");

            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("Inicio de la Automatizacion");
            }

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("hago click enn el boton de {string}")
    public void hagoClickEnnElBotonDe(String string) throws InterruptedException {
        FormPage formPage= new FormPage( super.driver);
        formPage.clickLoguin();
    }

    @When("ingreso mi correo electronico {string} y mi contrasena {string}")
    public void ingresoElCorreoElectronicoYLaContrasennaYAccedo(String correoElectronico, String contrasenna) {
        FormPage formPage= new FormPage( super.driver);
        formPage.fillMandatory2(correoElectronico,contrasenna);

    }
    @When("hago click enn el boton dee {string}")
    public void hagoClickEnnElBotonDee(String string) {

    }

    @Then("deberia ser redirigido nuevamente a la pagina principal y visualizar el {string} de usuario")
    public void deberiaSerRedirigidoNuevamenteALaPaginaPrincipalYVisualizarElDeUsuario(String string) {
        WebElement miCuentaButton = driver.findElement(By.xpath("(//a[@title='Mi cuenta'])[1]"));
        Assertions.assertTrue(miCuentaButton.isDisplayed(), "El botón 'Mi cuenta' no se muestra después de Iniciar sesion");
    }
}
