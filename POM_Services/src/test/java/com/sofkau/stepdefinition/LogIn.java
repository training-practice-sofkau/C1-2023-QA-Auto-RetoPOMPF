package com.sofkau.stepdefinition;
import com.sofkau.page.FormaDeLaPagina;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LogIn extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @When("Hago click en el boton acceder")
    public void hagoClickEnElBotonAcceder() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickAcceder();
    }
    @When("Ingreso mi correo y contrasena")
    public void ingresoMiCorreoYContrasena() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.ingresarCredenciales();
    }
    @When("Ingreso mi correo y contrasena incorrecta")
    public void ingresoMiCorreoYContrasenaIncorrecta() {
    }
    @When("Hago click en cerrar sesion")
    public void hagoClickEnCerrarSesion() {
    }
    @Then("Vuelve a la pagina principal y muestra el boton de acceder")
    public void vuelveALaPaginaPrincipalYMuestraElBotonDeAcceder() throws InterruptedException {
        Thread.sleep(2000);
        quitDriver();
    }
    @Then("En la parte superior sale un mensaje de error con un boton de perdiste tu contrasena")
    public void enLaParteSuperiorSaleUnMensajeDeErrorConUnBotonDePerdisteTuContrasena() throws InterruptedException {
        Thread.sleep(2000);
        quitDriver();
    }
    @Then("Vuelve a la pagina principal y muestra mi nombre de usuario en boton donde estaba el acceso")
    public void vuelveALaPaginaPrincipalYMuestraMiNombreDeUsuarioEnBotonDondeEstabaElAcceso() throws InterruptedException {
        FormaDeLaPagina formaDeLaPagina = new FormaDeLaPagina(super.driver);
        formaDeLaPagina.compararBotonAcceso();
        try {
            Assertions.assertEquals("DAMIR29305", FormaDeLaPagina.boton);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        } finally {
            quitDriver();
        }
        LOGGER.info("| Esperado | Obtenido | Resultado |");
        if (FormaDeLaPagina.boton.equalsIgnoreCase("DAMIR29305"))
            LOGGER.info("| DAMIR29305 | " +FormaDeLaPagina.boton+ " | cumple |");
        else
            LOGGER.info("| DAMIR29305 | "+FormaDeLaPagina.boton+" | no cumple |");
    }
}
