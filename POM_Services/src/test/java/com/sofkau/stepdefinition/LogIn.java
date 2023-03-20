package com.sofkau.stepdefinition;
import com.sofkau.page.FormaDeLaPagina;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LogIn extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("Estoy con mi sesion iniciada")
    public void estoyConMiSesionIciada() throws InterruptedException {
        hagoClickEnElBotonAcceder();
        ingresoMiCorreoYContrasena();
    }
    @When("Hago click en el boton acceder")
    public void hagoClickEnElBotonAcceder() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickAcceder();
    }
    @When("Ingreso mi correo y contrasena")
    public void ingresoMiCorreoYContrasena() throws InterruptedException {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.ingresarCredenciales();
    }
    @When("Ingreso mi correo y contrasena incorrecta")
    public void ingresoMiCorreoYContrasenaIncorrecta() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.ingresarCredencialesIncorrectas();
    }
    @When("Hago click en el boton con mi nombre de usuario")
    public void hagoClickEnElBotonConMiNombreDeUsuario() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickUsiario();
    }
    @When("Hago click en cerrar sesion")
    public void hagoClickEnCerrarSesion() {
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickSalir();
        formaDeLaPagina.cerrarSesion();
    }
    @Then("Vuelve a la pagina principal y muestra el boton de acceder")
    public void vuelveALaPaginaPrincipalYMuestraElBotonDeAcceder(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.botonAcceder();
        try{
            Assertions.assertEquals("ACCEDER / REGISTRARSE",FormaDeLaPagina.boton);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            Assertions.fail();
        }finally {
            quitDriver();
        }
        LOGGER.info("| Esperado | Obtenido | Resultado |");
        if (FormaDeLaPagina.boton.equalsIgnoreCase("ACCEDER / REGISTRARSE"))
            LOGGER.info("| ACCEDER / REGISTRARSE | "+FormaDeLaPagina.boton+" | cumple |");
        else
            LOGGER.info("| ACCEDER / REGISTRARSE | "+FormaDeLaPagina.boton+" | no cumple |");
    }
    @Then("En la parte superior sale un mensaje de error con un boton de perdiste tu contrasena")
    public void enLaParteSuperiorSaleUnMensajeDeErrorConUnBotonDePerdisteTuContrasena(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.mensajeError();
        try {
            Assertions.assertEquals("Perdiste tu contrase",FormaDeLaPagina.error.substring(1,21));
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            quitDriver();
        }
        LOGGER.info("| Esperado | Obtenido | Resultado |");
        if (FormaDeLaPagina.error.substring(1,21).equalsIgnoreCase("Perdiste tu contrase"))
            LOGGER.info("| Perdiste tu contrase | "+FormaDeLaPagina.error.substring(1,21)+" | cumple |");
        else
            LOGGER.info("| Perdiste tu contrase | "+FormaDeLaPagina.error.substring(1,21)+" | no cumple |");
    }
    @Then("Vuelve a la pagina principal y muestra mi nombre de usuario en boton donde estaba el acceso")
    public void vuelveALaPaginaPrincipalYMuestraMiNombreDeUsuarioEnBotonDondeEstabaElAcceso(){
        FormaDeLaPagina formaDeLaPagina = new FormaDeLaPagina(super.driver);
        formaDeLaPagina.compararBotonAcceso();
        try {
            Assertions.assertEquals("DAMIR29305", FormaDeLaPagina.boton);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
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
