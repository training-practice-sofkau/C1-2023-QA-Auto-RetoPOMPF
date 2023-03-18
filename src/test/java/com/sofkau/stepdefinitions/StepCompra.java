package com.sofkau.stepdefinitions;

import com.sofkau.models.FormModel;
import com.sofkau.pages.PagCarrito;
import com.sofkau.pages.CheckPag;
import com.sofkau.pages.PagPago;
import com.sofkau.pages.PagPrincipal;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class StepCompra extends WebUI {
    private FormModel formModelSCE2;
    private int totalFacturado;
    private static  final Logger logger = LogManager.getLogger(StepCompra.class);

    @Given("el cliente se encuentra en la categoria de ofertas")
    public void elClienteSeEncuentraEnLaCategoriaDeOfertas() {
        try{
            generalSetUp();
            PagPrincipal shoppingPag = new PagPrincipal(driver);
            shoppingPag.selectCategoryOffer();
        }catch (Exception e){
            quitDriver();
            logger.warn("Error al ingresar  categoria de ofertas\n ",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @When("el cliente seleccione los productos y los confirme en el carrito")
    public void elClienteSeleccioneLosProductosYLosConfirmeEnElCarrito() {
        try{
            PagPrincipal shoppingPag = new PagPrincipal(driver);
            PagCarrito cartPage = new PagCarrito(driver);
            shoppingPag.selectProductsRandom(3);
            cartPage.pressFinalizeBuy();
        }catch (Exception e){
            logger.warn("Error al seleccionar productos\n ",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @When("llene la informacion del formulario de pago y envie")
    public void lleneLaInformacionDelFormularioDePagoYEnvie() {
        try{
            addAttributesCustomer();
            PagPago formPayPage = new PagPago(driver, formModelSCE2);
            formPayPage.fillFormPay();
            totalFacturado= formPayPage.getTotalFacturado();
        }catch(Exception e){
            quitDriver();
            logger.warn("error al llenar el formulario\n ",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @Then("el sistema dirige a la pagina del formulario de pago")
    public void elSistemaDirigeALaPaginaDelFormularioDePago(){
        try{
            PagPago formPayPage = new PagPago(driver, formModelSCE2);
            Assertions.assertTrue(formPayPage.isTitleAppear());
        }catch (AssertionError e){
            quitDriver();
            logger.warn("error, no se direcciona a la página de pago\n",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @Then("el sistema debe calcular y mostrar el subtotal de los productos en la pagina del formulario de pago")
    public void elSistemaDebeCalcularYMostrarElSubtotalDeLosProductosEnLaPaginaDelFormularioDePago() {
        try {
            PagPago formPayPage= new PagPago(driver, formModelSCE2);
            Assertions.assertEquals(formPayPage.subTotalPrice(),formPayPage.getSubTotalPrice());
            logger.info("validación subtotal de productos, la entrada fue <$"+formPayPage.subTotalPrice()+
                    "> se obtuvo <$"+formPayPage.getSubTotalPrice()+">");
            quitDriver();
        }catch (AssertionError e){
            quitDriver();
            logger.warn("error, el subtotal es incorrecto \n",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @Then("el sistema confirma el envio del pedido")
    public void elSistemaConfirmaElEnvioDelPedido(){
        try{
            CheckPag confirmBuyPage = new CheckPag(driver);
            Assertions.assertTrue(confirmBuyPage.isDisplayMessageConfirmBuy());
        }catch (AssertionError e){
            quitDriver();
            logger.warn("no se confirma el envío \n",e);
            Assertions.fail(e.getMessage(),e);
        }
    }
    @Then("el sistema debe mostrar el correspondiente monto total en la factura")
    public void elSistemaDebeMostrarElCorrespondienteMontoTotalEnLaFactura(){
        CheckPag confirmBuyPage = new CheckPag(driver);
        try{
            int precioFacturaPage = confirmBuyPage.getPrecioTotalFactura();
            Assertions.assertEquals(totalFacturado,precioFacturaPage);
            logger.info("validación del monto total en factura: la entrada fue <$"+totalFacturado+
                    "> se obtuvo <$"+precioFacturaPage+">");
            quitDriver();
        }catch (AssertionError e){
            quitDriver();
            logger.warn("Verificación de datos de facturación fallida\n",e);
            Assertions.fail(e.getMessage(),e);
        }
    }

    protected void addAttributesCustomer(){
        formModelSCE2 = new FormModel();
        formModelSCE2.setCedula("897564321");
        formModelSCE2.setName("James");
        formModelSCE2.setLastName("Muñoz");
        formModelSCE2.setEmail("james@gmail.com");
        formModelSCE2.setAddress("calle 34");
        formModelSCE2.setNoAddress("107-08");
        formModelSCE2.setCity("Medellin");
        formModelSCE2.setRegion("Antioquia");
        formModelSCE2.setPhone("1234567890");
    }
}
