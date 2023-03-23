package com.sofkau.stepdefinition;
import com.sofkau.page.FormaDeLaPagina;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CambioDeContrasena extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("Estoy con mi sesion iniciada con la clave {string}")
    public void estoyConMiSesionIniciadaConLaClaveClaveAnterior(String string){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickAcceder();
        formaDeLaPagina.ingresarCredenciales(string);
    }
    @When("doy click en detalles de cuenta")
    public void doyClickEnDetallesDeCuenta() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickDetalles();
    }
    @When("hago el proceso de cambio de clave y guardo los cambios")
    public void hagoElProcesoDeCambioDeClaveYGuardoLosCambios() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.cambioContrasena("Prueba.test00","Test.prueba00");
    }
    @When("ingreso la clave anterior {string} y la clave nueva {string} y guardo los cambios")
    public void ingresoLaClaveAnteriorYLaClaveNuevaYGuardoLosCambios(String string, String string2) {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.cambioContrasena(string,string2);
    }
    @Then("Se recarga la pagina y sale un mensaje de que la informacion se cambio")
    public void seRecargaLaPaginaYSaleUnMensajeDeQueLaInformacionSeCambio() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.mensajeCambio();
        try {
            Assertions.assertEquals("de cuenta se ha cambiado correctamente.", FormaDeLaPagina.mensaje.substring(15));
        }catch(Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            quitDriver();
        }
        LOGGER.info("| Esperado | Obtenido | Resultado |");
        if (FormaDeLaPagina.mensaje.substring(15).equalsIgnoreCase("de cuenta se ha cambiado correctamente."))
            LOGGER.info("| de cuenta se ha cambiado correctamente. | "+FormaDeLaPagina.mensaje.substring(15)+" | cumple |");
        else
            LOGGER.info("| de cuenta se ha cambiado correctamente. | "+FormaDeLaPagina.mensaje.substring(15)+" | no cumple |");
    }

}
