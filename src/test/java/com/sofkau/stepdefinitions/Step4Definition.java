package com.sofkau.stepdefinitions;

import com.sofka.page.Activity4Page;
import com.sofka.page.ActivityPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class Step4Definition extends WebUI {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(Step4Definition.class));

    @Given("que estoy en la pagina de ZonaFit en {string}")
    public void queEstoyEnLaPaginaDeZonaFitEn(String navegador) {
        try{
            if (navegador.equals("edge")){
                generalSetUpEdge();
                LOGGER.info("se ha iniciado la automatizacion");
            } else if (navegador.equals("google")) {
                generalSetUpChrome();
                LOGGER.info("se ha iniciado la automatizacion");

            }
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(),e);
        }

        Activity4Page activity4Page= new Activity4Page(super.driver);

    }
    @Given("doy click en el boton de acceder-registrarse")
    public void doyClickEnElBotonDeAccederRegistrarse() throws InterruptedException {
        Activity4Page activity4Page= new Activity4Page(super.driver);
        activity4Page.clickLoguin();

    }
    @When("ingreso el correo electronico {string} y la contrasenna {string} y accedo")
    public void ingresoElCorreoElectronicoYLaContrasennaYAccedo(String string, String string2) {
        Activity4Page activity4Page= new Activity4Page(super.driver);
        activity4Page.fillMandatory2(string,string2);

    }
    @Then("deberia ser redirigido nuevamente a la pagina principal con mi sesion ya iniciada")
    public void deberiaSerRedirigidoNuevamenteALaPaginaPrincipalConMiSesionYaIniciada() {
        Activity4Page activity4Page = new Activity4Page(super.driver);
        boolean isElementPresent = activity4Page.isElementPresent("//span[@class='header-account-title']");
        Assertions.assertTrue(isElementPresent, "El usuario no ha iniciado sesión correctamente");
        if (isElementPresent) {
            LOGGER.info("La asercion de inicio de sesion ha sido exitosa");
        }
    }
}
