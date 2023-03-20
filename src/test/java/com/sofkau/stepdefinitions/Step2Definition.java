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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        LOGGER.info("se ha hecho click en el boton de facebook");
    }

    @When("me redirecciona a la pagina de facebook de ZonaFit")
    public void meRedireccionaALaPaginaDeFacebookDeZonaFit() {
        Activity2Page activity2Page = new Activity2Page(super.driver);
        String expectedUrl = "https://www.facebook.com/zonafitcol";
        String actualUrl = "";
        //uso una lista de identificadores de ventana
        //que estan abiertos en la sesion actual del navegador

        //uso el metodo getWindowHandles de la clase WebDriver
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            LOGGER.info("Si cumple, La redireccion a la pagina de Facebook de ZonaFit fue exitosa.");
        } else {
            LOGGER.error("La redirección a la pagina de Facebook de ZonaFit no fue exitosa. La URL actual es: " + actualUrl);
        }

        assertEquals(expectedUrl, actualUrl, "La URL actual no es la esperada: " + actualUrl);
    }

    @Then("puedo ver las publicaciones y videos de ZonaFit en su propia pagina")
    public void puedoVerLasPublicacionesYVideosDeZonaFitEnSuPropiaPagina() {
        Activity2Page activity2Page = new Activity2Page(super.driver);

    }

}
