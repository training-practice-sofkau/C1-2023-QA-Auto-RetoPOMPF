package com.sofkau.stepdefinitions;

import com.sofkau.pages.CommonActionPages;
import com.sofkau.pages.HomePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class StepSuscripcion extends WebUI {
    public static Logger LOGGER = Logger.getLogger(StepSuscripcion.class);

    private HomePage homePage;
    private CommonActionPages commonActionPages;

    @Given("que estoy en la pagina principal de zonafit.co")
    public void queEstoyEnLaPaginaPrincipalDeZonafitCo() {
        generalSetUp();
        homePage = new HomePage(driver);
        commonActionPages = new CommonActionPages(driver);
    }

    @When("bajo hasta la parte inferior de la pagina")
    public void bajoHastaLaParteInferiorDeLaPagina() {

        commonActionPages.scrollDown();
    }

    @When("lleno el formulario de suscribirse con mis datos y le doy clic al boton suscribirse")
    public void llenoElFormularioDeSuscribirseConMisDatosYLeDoyClicAlBotonSuscribirse() {
        String email = "james@mail.com";
        String name = " James";
        String phone = "123456789";

        homePage.setEmail(email);
        homePage.setName(name);
        homePage.setPhone(phone);
        homePage.clickSubscribeButton();
    }

    @Then("observo un texto que dice gracias por suscribirte en la misma pagina")
    public void observoUnTextoQueDiceGraciasPorSuscribirteEnLaMismaPagina() {
        boolean textPresent = commonActionPages.isTextPresent("gracias por suscribirte");
        assertTrue(textPresent);
    }

    //Scenario 2
    @Then("observo un texto que dice correo electronico no es valido")
    public void observoUnTextoQueDiceCorreoElectronicoNoEsValido() {
        boolean textPresent = commonActionPages.isTextPresent("correo electronico no es valido");
        assertTrue(textPresent);
    }

    @After
    public void afterTest() {
        quitDriver();
    }
}


