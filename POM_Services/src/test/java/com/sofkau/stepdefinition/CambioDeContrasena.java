package com.sofkau.stepdefinition;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
public class CambioDeContrasena extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @When("doy click en detalles de cuenta")
    public void doyClickEnDetallesDeCuenta() {
    }
    @When("hago el proceso de cambio de clave y guardo los cambios")
    public void hagoElProcesoDeCambioDeClaveYGuardoLosCambios() {
    }
    @When("ingreso la clave anterior {string} y la clave nueva {string} y guardo los cambios")
    public void ingresoLaClaveAnteriorYLaClaveNuevaYGuardoLosCambios(String string, String string2) {
    }
    @Then("Se recarga la pagina y sale un mensaje de que la informacion se cambio")
    public void seRecargaLaPaginaYSaleUnMensajeDeQueLaInformacionSeCambio() {
        quitDriver();
    }
}
