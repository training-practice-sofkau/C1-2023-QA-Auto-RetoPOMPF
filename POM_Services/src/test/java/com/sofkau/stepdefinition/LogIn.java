package com.sofkau.stepdefinition;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
public class LogIn extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @When("Hago click en el boton acceder")
    public void hagoClickEnElBotonAcceder() {
    }
    @When("Ingreso mi correo y contrasena")
    public void ingresoMiCorreoYContrasena() {
    }
    @When("Ingreso mi correo y contrasena incorrecta")
    public void ingresoMiCorreoYContrasenaIncorrecta() {
    }
    @When("Hago click en cerrar sesion")
    public void hagoClickEnCerrarSesion() {
    }
    @Then("Vuelve a la pagina principal y muestra el boton de acceder")
    public void vuelveALaPaginaPrincipalYMuestraElBotonDeAcceder() {
        quitDriver();
    }
    @Then("En la parte superior sale un mensaje de error con un boton de perdiste tu contrasena")
    public void enLaParteSuperiorSaleUnMensajeDeErrorConUnBotonDePerdisteTuContrasena() {
        quitDriver();
    }
    @Then("Vuelve a la pagina principal y muestra mi nombre de usuario en boton donde estaba el acceso")
    public void vuelveALaPaginaPrincipalYMuestraMiNombreDeUsuarioEnBotonDondeEstabaElAcceso() {
        quitDriver();
    }
}
