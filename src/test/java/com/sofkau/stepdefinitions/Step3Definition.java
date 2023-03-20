package com.sofkau.stepdefinitions;

import com.sofka.model.Suscripcion;
import com.sofka.page.ActivityPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Step3Definition extends WebUI {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(Step3Definition.class));
    private ActivityPage activityPage;
    Suscripcion s = new Suscripcion();
    @Given("que me encuentro en el  sitio web de ZonaFit con {string}")
    public void queMeEncuentroEnElSitioWebDeZonaFitCon(String navegador) {
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

        ActivityPage activityPage = new ActivityPage(super.driver,s);


    }
    @When("decido subscribirme al NewsLetter")
    public void decidoSubscribirmeAlNewsLetter() {
        ActivityPage activityPage = new ActivityPage(super.driver,s);
        activityPage.scrollDown();

    }
    @When("lleno todos los datos requeridos en el formulario")
    public void llenoTodosLosDatosRequeridosEnElFormulario() {
        informationPerson();
        ActivityPage activityPage = new ActivityPage(super.driver,s);

        activityPage.fillMandatoryFields();

    }
    @Then("deberia ver un mensaje de exito diciendo {string}")
    public void deberiaVerUnMensajeDeExitoDiciendo(String expected) {
        ActivityPage activityPage = new ActivityPage(super.driver,s);
        String actual= activityPage.getMessage();
        Assertions.assertEquals(expected.substring(1,25),"Gracias por suscribirse!");

    }
    @When("dejo un campo en blanco de los datos requeridos en el formulario")
    public void dejoUnCampoEnBlancoDeLosDatosRequeridosEnElFormulario() {
        ActivityPage activityPage = new ActivityPage(super.driver,s);
        informationPersonIncompleta();
        activityPage.fillMandatoryFields0();

    }
    @Then("deberia ver un mensaje de error indicando que la subscripcion no se pudo completar")
    public void deberiaVerUnMensajeDeErrorIndicandoQueLaSubscripcionNoSePudoCompletar() {
        WebElement errorMessage = driver.findElement(By.xpath("(//div[@for='mce-FNAME'])[1]"));
        String errorText = errorMessage.getText();
        Assertions.assertEquals("Este campo es obligatorio.", errorText);
        LOGGER.info("Cumple: El mensaje de error de suscripcion incompleta se muestra correctamente.");

    }
    public void informationPerson(){
        s=new Suscripcion();
        s.setCorreo("meli12menesesacevedo@gmail.com");
        s.setNombre("Melisita Meneses");
        s.setCelular("3127357862");

    }
    public void informationPersonIncompleta(){
        s.setCelular("3225448855");
        s.setCorreo("famimenE@gmail.com");
    }





}
