package com.sofkau.stepdefinitions;

import com.sofkau.pages.PagPrincipal;
import com.sofkau.pages.common.CommonActionOnpages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.After;

import static org.junit.Assert.assertTrue;

public class StepSuscripcion extends WebUI {
    public static Logger LOGGER = Logger.getLogger(StepSuscripcion.class);

    private PagPrincipal pagPrincipal;
    private CommonActionOnpages commonActionOnPages;

    @Given("que estoy en la pagina principal de zonafit.co")
    public void queEstoyEnLaPaginaPrincipalDeZonafitCo() {
        generalSetUp();
        pagPrincipal = new PagPrincipal(driver);
        commonActionOnPages = new CommonActionOnpages(driver);
    }

    @When("bajo hasta la parte inferior de la pagina")
    public void bajoHastaLaParteInferiorDeLaPagina() {

        commonActionOnPages.scrollDown();
    }

    @When("lleno el formulario de suscribirse con mis datos y le doy clic al boton suscribirse")
    public void llenoElFormularioDeSuscribirseConMisDatosYLeDoyClicAlBotonSuscribirse() {
        String email = "james@mail.com";
        String name = " James";
        String phone = "123456789";

        pagPrincipal.setEmail(email);
        pagPrincipal.setName(name);
        pagPrincipal.setPhone(phone);
        pagPrincipal.clickSubscribeButton();
    }

    @Then("observo un texto que dice gracias por suscribirte en la misma pagina")
    public void observoUnTextoQueDiceGraciasPorSuscribirteEnLaMismaPagina() {
        boolean textPresent = commonActionOnPages.isTextPresent("gracias por suscribirte");
        assertTrue(textPresent);
    }

    //Scenario 2
    @Then("observo un texto que dice correo electronico no es valido")
    public void observoUnTextoQueDiceCorreoElectronicoNoEsValido() {
        boolean textPresent = commonActionOnPages.isTextPresent("correo electronico no es valido");
        assertTrue(textPresent);
    }

    @After
    public void afterTest() {
        quitDriver();
    }
}


