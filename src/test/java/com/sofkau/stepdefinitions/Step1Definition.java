package com.sofkau.stepdefinitions;

import com.sofka.model.Facturacion;
import com.sofka.page.Activity1Page;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class Step1Definition extends WebUI {
    private Activity1Page activity1Page;
    Facturacion f = new Facturacion();
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(Step1Definition.class));
    @Given("que estoy en el sitio web de ZonaFit con {string}")
    public void queEstoyEnElSitioWebDeZonaFitCon(String navegador) {
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

         Activity1Page activity1Page1 = new Activity1Page(super.driver,f);

    }
    @When("procedo a agregar al carrito los productos de mi interes")
    public void procedoAAgregarAlCarritoLosProductosDeMiInteres() throws InterruptedException {
        Activity1Page activity1Page1 = new Activity1Page(super.driver,f);
        activity1Page1.agregar();


    }
    @When("ingreso todos mis datos personales y selecciono el metodo de pago")
    public void ingresoTodosMisDatosPersonalesYSeleccionoElMetodoDePago() {
        infoFormulario();
        Activity1Page activity1Page1 = new Activity1Page(super.driver,f);
        activity1Page1.type();

    }
    @Then("debo ver un mensaje de confirmacion de compra exitoso")
    public void deboVerUnMensajeDeConfirmacionDeCompraExitoso() {
        Activity1Page activity1Page1 = new Activity1Page(super.driver,f);

    }

    @When("dejo un campo en blanco en la informacion requerida")
    public void dejoUnCampoEnBlancoEnLaInformacionRequerida() {
        infoFormularioIncompleto();
        Activity1Page activity1Page1 = new Activity1Page(super.driver,f);
        activity1Page1.type0();

    }
    @Then("debo ver un mensaje indicando el error")
    public void deboVerUnMensajeIndicandoElError() {
        Activity1Page activity1Page1 = new Activity1Page(super.driver,f);

    }

    public void infoFormulario(){
        f =new Facturacion();
        f.setDocumento("1000756218");
        f.setEmail("luisito1995@gmail.com");
        f.setNombre("Luis");
        f.setApellido("Meneses");
        f.setLugar1("CALDAS");
        f.setLugar2("MANIZALES (CDAS)");
        f.setDireccion("carrea 56 #34-N");
        f.setDireccion2("apto 201");
        f.setTelefono("6065263966");
        f.setNotas_adicionales("por favor entregar a la sennora Carmensa , gracias.");
    }

    public void infoFormularioIncompleto(){

        f =new Facturacion();
        f.setDocumento("1000756218");
        f.setApellido("Meneses");
        f.setLugar1("CALDAS");
        f.setLugar2("MANIZALES (CDAS)");
        f.setDireccion("carrea 56 #34-N");
        f.setDireccion2("apto 201");
        f.setTelefono("6065263966");
        f.setNotas_adicionales("por favor entregar a la señora Carmensa , gracias.");
    }



}
