package com.sofkau.stepdefinitions;

import com.sofka.page.Activity2Page;
import com.sofka.page.ActivityPage;
import com.sofka.page.CommonActionOnPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Step2Definition extends WebUI {


    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(Step2Definition.class));



    @Given("que estoy en la pagina web de ZonaFit en {string}")
    public void queEstoyEnLaPaginaWebDeZonaFitEn(String navegador) {

        try{
            if (navegador.equals("edge")){
                generalSetUpEdge();
                LOGGER.info("se ha iniciado la automatizacion");
            } else if (navegador.equals("google")) {
                generalSetUpChrome();
                LOGGER.info("se ha iniciado la automatizacion");
            }
        } catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(),e);
        }

        Activity2Page activity2Page = new Activity2Page(super.driver);
    }

    @When("selecciono la opcion de Facebook")
    public void seleccionoLaOpcionDeFacebook() {
        Activity2Page activity2Page = new Activity2Page(super.driver);
        activity2Page.clickFacebookButton();
        LOGGER.info("se ha hecho click en el botón de facebook");
    }

    @When("me redirecciona a la pagina de facebook de ZonaFit")
    public void meRedireccionaALaPaginaDeFacebookDeZonaFit() {
        Activity2Page activity2Page = new Activity2Page(super.driver);

    }

    @Then("puedo ver las publicaciones y videos de ZonaFit en su propia pagina")
    public void puedoVerLasPublicacionesYVideosDeZonaFitEnSuPropiaPagina() {
        Activity2Page activity2Page = new Activity2Page(super.driver);
        String expectedUrl = "https://www.facebook.com/zonafitcol";
        String actualUrl = super.driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "La redireccion a la pagina de Facebook de ZonaFit no fue exitosa.");
    }

}
