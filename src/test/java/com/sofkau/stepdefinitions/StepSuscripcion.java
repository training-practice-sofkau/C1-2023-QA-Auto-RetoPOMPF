package com.sofkau.stepdefinitions;

import com.sofkau.pages.PagPrincipal;
import com.sofkau.pages.common.CommonActionPages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import static org.junit.Assert.assertEquals;

public class StepSuscripcion extends WebUI {
    public static Logger LOGGER = Logger.getLogger(StepSuscripcion.class);
    private PagPrincipal pagPrincipal;
    private CommonActionPages commonActionOnPages;


    @Given("que estoy en la pagina principal del {string}")
    public void queEstoyEnLaPaginaPrincipalDelNavegador(String navegador) {

        if (navegador.equals("chrome")) {
            setUpWebdriver();
            pagPrincipal = new PagPrincipal(driver);
            commonActionOnPages = new CommonActionPages(driver);
        } else if (navegador.equals("edge")) {
            setUpWebdriver1();
            pagPrincipal = new PagPrincipal(driver);
            commonActionOnPages = new CommonActionPages(driver);
        }
    }
    @When("bajo hasta la parte inferior de la pagina")
    public void bajoHastaLaParteInferiorDeLaPagina() {
        commonActionOnPages.scrollDown();

    }
    @When("lleno el formulario de suscribirse con {string}, {string} y {string} y le doy clic al boton suscribirse")
    public void llenoElFormularioDeSuscribirseConDatosYLeDoyClicAlBotonSuscribirse(String email, String name, String phone) throws InterruptedException {
        pagPrincipal.setEmail(email);
        pagPrincipal.setName(name);
        pagPrincipal.setPhone(phone);
        pagPrincipal.clickSubscribeButton();
        Thread.sleep(4000);
    }

    @Then("observo un texto que dice Gracias por suscribirse en la misma pagina")
    public void observoUnTextoQueDiceGraciasPorSuscribirseEnLaMismaPagina() {
        String expectedText = "Gracias por suscribirse!";
        String actualText = driver.findElement(By.xpath("//div[@id='mce-responses']/div[@id='mce-success-response']"))
                .getText().trim().substring(1);
        LOGGER.info("Valor Esperado:" + expectedText);
        LOGGER.info("Valor Actual:" + actualText);
        assertEquals(expectedText, actualText);

    }
}

//Scenario 2
    /*@Then("observo un texto que dice correo electronico no es valido")
    public void observoUnTextoQueDiceCorreoElectronicoNoEsValido() {
        boolean textPresent = commonActionOnPages.isTextPresent("correo electronico no es valido");
        assertTrue(textPresent);
    }
    @After
    public void afterTest() {
        quitDriver();
    }
     */



