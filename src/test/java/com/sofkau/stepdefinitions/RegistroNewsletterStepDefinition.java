package com.sofkau.stepdefinitions;

import com.sofkau.pages.CommonActionOnPages;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;


public class RegistroNewsletterStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(RegistroNewsletterStepDefinition.class);


    private CommonActionOnPages commonActionOnPages;
    @Given("que el administador se encuentra en la pagina de inicio de ZonaFit desde {string}")
    public void queElAdministadorSeEncuentraEnLaPaginaDeInicioDeZonaFitDesde(String navegador) {
        FormPage formPage = new FormPage(super.driver);
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

    @When("el usuario hace scroll hacia el final de la pagina de inicio")
    public void elUsuarioHaceScrollHaciaElFinalDeLaPaginaDeInicio() {
       FormPage formPage = new FormPage(super.driver);
        formPage.scrollDown();
    }
    @When("se le solicita que ingrese en el campo correspondiente su direccion de correo electronico, su nombre completo y su celular.")
    public void seLeSolicitaQueIngreseEnElCampoCorrespondienteSuDireccionDeCorreoElectronicoSuNombreCompletoYSuCelular() {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillForm("PedroPascal30@hotmail.com", "Pedro Pascalis", "3105438123");
    }
    @When("hace clic en el boton {string}")
    public void haceClicEnElBoton(String buttonName) {
        FormPage formPage = new FormPage(super.driver);

        formPage.clickSubscribeButton();
    }
    @Then("el sistema deberia mostrar el siguiente mensaje {string}")
    public void elSistemaDeberiaMostrarElSiguienteMensaje(String expectedMessage) {
        FormPage formPage = new FormPage(super.driver);
        String actualMessage = formPage.getSuccessMessage();
        Assertions.assertEquals(expectedMessage.substring(1,25), "Gracias por suscribirse!");
    }

}
